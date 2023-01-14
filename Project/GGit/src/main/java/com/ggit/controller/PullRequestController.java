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
            
            int state = 2;
            for(int i=0; i<changed.size(); i++){
                PullreqVo2 pullreqVo2 = new PullreqVo2(); // vo 객체 생성
                state = 2;
                for(int j=0; j<mainchanged.size(); j++){

                    String changed_str_path = (String)((JSONObject) changed.get(i)).get("path");
                    String mainChanged_str_path = (String)((JSONObject) mainchanged.get(j)).get("path");

                    // merge
                    // 1
                    // 2
                    // 3

                    // main
                    // 1
                    // 2
                    if(changed_str_path.equals(mainChanged_str_path)){
                        state = 0;
                        pullreqVo2.setFilePath( (String)((JSONObject) changed.get(i)).get("path") );

                        fileName_arr = pullreqVo2.getFilePath().split("/");
                        String fileName = fileName_arr[fileName_arr.length-1];
                        pullreqVo2.setFileName(fileName);

                        // 파일의 상태 저장 (add, change, del)
                        pullreqVo2.setFilestate((String)((JSONObject) changed.get(i)).get("state"));
                        pullreqVo2.setFilestate((String)((JSONObject) mainchanged.get(j)).get("state"));


                        String path = "STORAGE/repositorys/" + repo_idx + "/" + pullreqVo.getToken() + "/data" + (String)((JSONObject) changed.get(i)).get("path");
                        String pathmain = "STORAGE/repositorys/" + repo_idx + "/" + pullreqVo.getToken() + "/data" + (String)((JSONObject) mainchanged.get(j)).get("path");

                        BufferedReader inFiles = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
                        BufferedReader inFilesmain = new BufferedReader(new InputStreamReader(new FileInputStream(pathmain), StandardCharsets.UTF_8));


                        ArrayList<String> data_arrList = new ArrayList<String>();
                        ArrayList<String> main_Data_arrList = new ArrayList<String>();
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sbMain = new StringBuilder();

                        String line = "";
                        while((line = inFiles.readLine()) != null){
                            data_arrList.add(line + "\n");
                            sb.append(line+"\n");
                            //sb.append(line);
                        }

                        String lineMain = "";
                        while((lineMain = inFilesmain.readLine()) != null){
                            main_Data_arrList.add(lineMain + "\n");
                            sbMain.append(lineMain+"\n");
                            //sb.append(line);
                        }

                        //.readLine()은 끝에 개행문자를 읽지 않는다.  
                        pullreqVo2.setFileData(data_arrList);
                        pullreqVo2.setFileDataMain(main_Data_arrList);

                        pullreqVo2.setSb_vo(sb);
                        pullreqVo2.setSb_vo_main(sbMain);

                        pullreqVo2.setState(state);

                        inFiles.close();
                        
                        

                    }else{
                        

                    }

                   

                }        
   
            } // for문

           
            

        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        return file_name_path;

    }

}
