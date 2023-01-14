package com.ggit.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ggit.service.PullreqService;
import com.ggit.util.ReadData;
import com.ggit.vo.PullreqVo;
import com.ggit.vo.PullreqVo2;
import com.ggit.vo.RepoVo;

@RestController
public class PullRequestController {

    @Autowired
    RepoVo repoVo;

    @Autowired
    PullreqVo pullreqVo;

    @Autowired
    PullreqService pullreqService;

    // @Autowired
    // PullreqVo2 pullreqVo2;
    @Value("${storage_dir}")
    String storage_dir;

    @RequestMapping("merge_request")
    public int merge_request(@RequestBody PullreqVo pullreqVo) {
        // 저장소 idx와 user idx를 가지고
        // 저장소에 속한 멤버이면 : 저장소 멤버 병합 요청 후 ~병합
        // 저장소에 속하지 않은 멤버이면 : 병합 요청만 ~되고 저장소 주인 또는 권한이 있는 멤버가 병합 가능

        // 저장소에 속해 있는지 확인
        // System.out.println("==>" + pullreqService.repoInMem(repoVo));
        if (pullreqService.repoInMem(pullreqVo) == null) { // 저장소 멤버가 아닐때
            return pullreqService.pullrequest(pullreqVo);
        } else { // 저장소 멤버일때
            return pullreqService.pullrequest(pullreqVo);
        }
    }

    // 저장소 idx로 병합요청 조회
    @RequestMapping("pullreq_select")
    public List<PullreqVo> pullreq_select(@RequestBody PullreqVo pullreqVo) {
        return pullreqService.pullreq_select(pullreqVo.getIdx());
    }

    // 저장소 idx로 병합요청(멤버) 조회
    @RequestMapping("pullreq_select_mem")
    public List<PullreqVo> pullreq_select_mem(@RequestBody PullreqVo pullreqVo) {
        return pullreqService.pullreq_select_mem(pullreqVo.getIdx());
    }

    @RequestMapping("testcon")
    public ArrayList<PullreqVo2> testcon(@RequestBody PullreqVo pullreqVo) {

        // System.out.println("==> " + pullreqVo.getToken()); // 서버에 저장되있는 Data 가져오기
        // System.out.println("=======> " + pullreqVo.getRepo_idx()); // idx의 최신
        // main파일토큰 가져오기

        /////////////////////////////////////////////////////////////////////////////////////
        int repo_idx = pullreqVo.getRepo_idx();
        String[] fileName_arr;
        ArrayList<PullreqVo2> file_name_path = new ArrayList<PullreqVo2>();

        // 병합 파일 경로
        String MergePath = storage_dir + "repositorys/" + repo_idx + "/" + pullreqVo.getToken()
                + "/dump/pushChanged2.txt";

        // 메인 파일 경로
        String LastMainToken = pullreqService.getLastMainToken(pullreqVo.getRepo_idx()); // idx의 최신 main파일토큰 가져오기
        String MainMergePath = storage_dir + "repositorys/" + repo_idx + "/" + LastMainToken + "/dump/pushChanged1.txt";
        System.out.println("adasd => " + LastMainToken);

        JSONArray changed = null;
        JSONArray mainchanged = null;

        try {
            // 병합 파일의 pushChanged2 내용 가져오기
            String con = new ReadData(MergePath).getCon();
            changed = (JSONArray) (new JSONParser()).parse(con);

            // 메인 파일의 pushChanged1 내용 가져오기
            String maincon = new ReadData(MainMergePath).getCon();
            mainchanged = (JSONArray) (new JSONParser()).parse(maincon);

            System.out.println("메인=> " + mainchanged);
            // System.out.println("메인병합파일 => " + mainchanged);
            int marginState = 2;
            for (int i = 0; i < changed.size(); i++) {
                PullreqVo2 pullreqVo2 = new PullreqVo2(); // vo 객체 생성
                // System.out.println("======>" + (String)((JSONObject)
                // changed.get(i)).get("path")); // 병합파일의 경로 출력
                marginState = 2;
                for (int j = 0; j < mainchanged.size(); j++) {

                    String changed_str_path = (String) ((JSONObject) changed.get(i)).get("path");
                    String mainChanged_str_path = (String) ((JSONObject) mainchanged.get(j)).get("path");
                    if (changed_str_path.equals(mainChanged_str_path)) {

                        System.out.println("같은 경로가 있음");
                        System.out.println(changed_str_path);
                        System.out.println(mainChanged_str_path);
                        marginState = 0;

                    } else {
                        System.out.println("같은 경로가 없음!!");
                        System.out.println(changed_str_path);
                        System.out.println(mainChanged_str_path);
                        pullreqVo2.setMarginState(2);
                    }
                }
                pullreqVo2.setMarginState(marginState);
                pullreqVo2.setFilePath((String) ((JSONObject) changed.get(i)).get("path"));

                fileName_arr = pullreqVo2.getFilePath().split("/");
                String fileName = fileName_arr[fileName_arr.length - 1];
                pullreqVo2.setFileName(fileName);

                String path = storage_dir + "repositorys/" + repo_idx + "/" + pullreqVo.getToken() + "/data"
                        + (String) ((JSONObject) changed.get(i)).get("path");
                ArrayList<String> data_arrList = new ArrayList<String>();
                StringBuilder sb = new StringBuilder();

                ArrayList<String> main_Data_arrList = new ArrayList<String>();

                BufferedReader inFiles = new BufferedReader(
                        new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));

                String line = "";
                while ((line = inFiles.readLine()) != null) {
                    data_arrList.add(line + "\n");
                    sb.append(line + "\n");
                    // sb.append(line);
                }
                // .readLine()은 끝에 개행문자를 읽지 않는다.
                pullreqVo2.setFileData(data_arrList);
                pullreqVo2.setSb_vo(sb);
                inFiles.close();

                file_name_path.add(pullreqVo2);
            } // for문
              // System.out.println("=>" + test_path);

        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        return file_name_path;

    }

}
