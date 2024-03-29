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
import java.util.Map;

import javax.websocket.server.PathParam;

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
import com.ggit.service.PushService;
import com.ggit.util.CopyFile;
import com.ggit.util.PushZip;
import com.ggit.util.RandStr;
import com.ggit.util.ReadData;
import com.ggit.util.WriteData;
import com.ggit.vo.PullreqVo;
import com.ggit.vo.PullreqVo2;
import com.ggit.vo.PushVo;
import com.ggit.vo.RepoVo;

@RestController
public class PullRequestController {

    @Autowired
    RepoVo repoVo;

    @Autowired
    PullreqVo pullreqVo;

    @Autowired
    PushVo pushVo;

    @Autowired
    PullreqService pullreqService;

    @Autowired
    PushService pushService;

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

    @RequestMapping("go_pullreq")
    public List<PullreqVo> go_pullreq(@RequestBody String list) {
        JSONObject jo;
        try {

            jo = (JSONObject) (new JSONParser().parse(list));// 가져온 margedata
            JSONArray data = (JSONArray) jo.get("list");// 가져온 margedata를 배열로 쪼겐거 구조가 [pullreqVo2,pullreqvo2,pullreqvo2]
                                                        // 라고 생각하면 됨 대신 다 json임
            String repo = ((JSONObject) data.get(0)).get("repo") + "";// repo
            String token = ((JSONObject) data.get(0)).get("token") + "";// token
            String mainToken = pushService.maintoken(repo);// 메인토큰
            String newToken = new RandStr(15).getResult(); // 새로운 토큰값
            String member = ((JSONObject) data.get(0)).get("member") + "";

            boolean fast = (boolean) ((JSONObject) data.get(0)).get("fast");// 빠른병합인지여부

            String mainPath = storage_dir + "repositorys/" + repo + "/" + mainToken;// 메인 폴더위치
            String marge = storage_dir + "repositorys/" + repo + "/" + token;// 병합 폴더 우치
            String newPath = storage_dir + "repositorys/" + repo + "/" + newToken;// 새로만들어질 폴더 위치
            File newFile = new File(newPath);
            newFile.mkdirs();// 새로운폴더 만들고

            new CopyFile().copy(new File(mainPath), newFile);// 우선 메인 파일 전체를 가져온다

            String path = "";// 파일 경로 for문에서 사용할거
            String con = "";// 파일 내용 for문에서 사용할거
            String marginState = "";
            String file_state = "";
            String pushDataCon = new ReadData(newPath + "/.ggit/.repo/file/dump/pushData.txt").getCon();

            JSONArray pushData = (JSONArray) new JSONParser().parse(pushDataCon);
            for (int i = 0; i < data.size(); i++) {
                path = newPath + "/data" + ((JSONObject) (data.get(i))).get("filePath") + "";// 새로운 폴더 기반 하나의 파일 경로
                con = ((JSONObject) (data.get(i))).get("sb_vo_merge") + "";// 하나의 파일 내용
                marginState = ((JSONObject) (data.get(i))).get("marginState") + "";
                file_state = ((JSONObject) (data.get(i))).get("file_state") + "";
                new File(new File(path).getParent()).mkdirs();
                new WriteData(path).write(con);
                System.out.println(marginState);
                System.out.println(file_state);
            }

            // ~로부터 병합
            String nick = pullreqService.fromMemberNick(member);
            System.out.println("nick ==> " + nick);

            pushVo.setToken(newToken);
            pushVo.setMember(Integer.parseInt(member));
            pushVo.setRepo(Integer.parseInt(repo));
            pushVo.setMessage("'" + nick + "'로부터 병합");
            // pushVo.setDate();
            pushVo.setBranch(0);
            pushVo.setBefore_token(newToken);
            pushVo.setFromMain(0);
            pushVo.setSelected(0);
            pushVo.setMain_token(mainToken);

            savePullreq(fast, token);
            Thread.sleep(1200);
            int savePush_result = savePush(pushVo);
            System.out.println("savePush_result : " + savePush_result);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    // 함수만들고 디비 저장!
    public void savePullreq(boolean fast, String token) {

        if (fast) {
            pullreqService.savePullreq(2, token);
            return;
        }
        pullreqService.savePullreq(1, token);
    }

    public int savePush(PushVo pushVo) {
        return pullreqService.savePush(pushVo);
    }

    @RequestMapping("testcon")
    public ArrayList<PullreqVo2> testcon(@RequestBody PullreqVo pullreqVo) {
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
            
            int marginState = 2;
            for (int i = 0; i < changed.size(); i++) {
                PullreqVo2 pullreqVo2 = new PullreqVo2(); // vo 객체 생성

                marginState = 2;
                for (int j = 0; j < mainchanged.size(); j++) {

                    String changed_str_path = (String) ((JSONObject) changed.get(i)).get("path");
                    String mainChanged_str_path = (String) ((JSONObject) mainchanged.get(j)).get("path");

                    String file_state_main = (String) ((JSONObject) changed.get(i)).get("state");
                    String file_state_merge = (String) ((JSONObject) mainchanged.get(j)).get("state");

                    if (changed_str_path.equals(mainChanged_str_path)) {

                        System.out.println("같은 경로가 있음");
                        System.out.println(changed_str_path);
                        System.out.println(mainChanged_str_path);
                        marginState = 0;

                        ArrayList<String> data_arrList_main = new ArrayList<String>();

                        String path_main = storage_dir + "repositorys/" + repo_idx + "/" + LastMainToken + "/data"
                                + (String) ((JSONObject) mainchanged.get(j)).get("path");

                        StringBuilder sb_main = new StringBuilder();

                        BufferedReader inFilesMain = new BufferedReader(
                                new InputStreamReader(new FileInputStream(path_main), StandardCharsets.UTF_8));

                        String line_main = "";
                        while ((line_main = inFilesMain.readLine()) != null) {
                            data_arrList_main.add(line_main + "\n");
                            sb_main.append(line_main + "\n");
                        }

                        pullreqVo2.setFileDataMain(data_arrList_main);
                        pullreqVo2.setSb_vo_main(sb_main);
                        pullreqVo2.setFile_state_merge(file_state_merge);
                        pullreqVo2.setFile_state_main(file_state_main);

                    } else {
                        System.out.println("같은 경로가 없음!!");
                        System.out.println(changed_str_path);
                        System.out.println(mainChanged_str_path);
                        pullreqVo2.setMarginState(2);
                    }
                } // for문

                pullreqVo2.setMarginState(marginState);
                pullreqVo2.setFilePath((String) ((JSONObject) changed.get(i)).get("path"));

                fileName_arr = pullreqVo2.getFilePath().split("/");
                String fileName = fileName_arr[fileName_arr.length - 1];
                pullreqVo2.setFileName(fileName);

                String path = storage_dir + "repositorys/" + repo_idx + "/" + pullreqVo.getToken() + "/data"
                        + (String) ((JSONObject) changed.get(i)).get("path");
                ArrayList<String> data_arrList = new ArrayList<String>();
                StringBuilder sb = new StringBuilder();

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
