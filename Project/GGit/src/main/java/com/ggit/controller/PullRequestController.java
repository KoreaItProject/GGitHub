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


    @RequestMapping("merge_request")
    public int merge_request(@RequestBody PullreqVo pullreqVo){
        // 저장소 idx와 user idx를 가지고 
        // 저장소에 속한 멤버이면 : 저장소 멤버 병합 요청 후 ~병합
        // 저장소에 속하지 않은 멤버이면 : 병합 요청만 ~되고 저장소 주인 또는 권한이 있는 멤버가 병합 가능

        // 저장소에 속해 있는지 확인
        //System.out.println("==>" + pullreqService.repoInMem(repoVo));
        if(pullreqService.repoInMem(pullreqVo) == null){ // 저장소 멤버가 아닐때
            return pullreqService.pullrequest(pullreqVo);
        }else{ // 저장소 멤버일때
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
    public ArrayList<PullreqVo2> testcon(@RequestBody PullreqVo pullreqVo){
        
        //System.out.println("==> " + pullreqVo.getToken()); // 서버에 저장되있는 Data 가져오기
        //System.out.println("=======> " + pullreqVo.getRepo_idx()); // idx의 최신 main파일토큰 가져오기


        /////////////////////////////////////////////////////////////////////////////////////
        int repo_idx = pullreqVo.getRepo_idx(); 
        String[] fileName_arr;
        ArrayList<PullreqVo2> file_name_path = new ArrayList<PullreqVo2>();

        String MergePath = "STORAGE/repositorys/" + repo_idx + "/" + pullreqVo.getToken() + "/dump/pushChanged2.txt";
        JSONArray changed = null;
        
        try {
            String con = new ReadData("STORAGE\\repositorys\\" + repo_idx + "\\" + pullreqVo.getToken() + "\\dump\\pushChanged2.txt")
                    .getCon();
            changed = (JSONArray) (new JSONParser()).parse(con);
            for(int i=0; i<changed.size(); i++){
                PullreqVo2 pullreqVo2 = new PullreqVo2();
                pullreqVo2.setFilePath( (String)((JSONObject) changed.get(i)).get("path") );

                fileName_arr = pullreqVo2.getFilePath().split("/");
                String fileName = fileName_arr[fileName_arr.length-1];
                pullreqVo2.setFileName(fileName);

                try{
                    //BufferedReader inFiles = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/com/ggit/config/testfile.txt"), StandardCharsets.UTF_8));
                    String path = "STORAGE/repositorys/" + repo_idx + "/" + pullreqVo.getToken() + "/data" + (String)((JSONObject) changed.get(i)).get("path");
                    ArrayList<String> data_arrList = new ArrayList<String>();

                    BufferedReader inFiles = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        
                    String line = "";
                    while((line = inFiles.readLine()) != null){
                        data_arrList.add(line);
                    }
                    //.readLine()은 끝에 개행문자를 읽지 않는다.  
                    pullreqVo2.setFileData(data_arrList);          
                    inFiles.close();
                }catch (FileNotFoundException e) {
                    // TODO: handle exception
                }catch(IOException e){
                    System.out.println(e);
                }
                file_name_path.add(pullreqVo2);
            }
            //System.out.println("=>" + test_path);
            
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        

        String LastMainToken = pullreqService.getLastMainToken(pullreqVo.getRepo_idx()); // idx의 최신 main파일토큰 가져오기
        /////////////////////////////////////////////////////////////////////////////////


        ArrayList<String> test_line = new ArrayList<String>();
        
        try{
            //BufferedReader inFiles = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/com/ggit/config/testfile.txt"), StandardCharsets.UTF_8));
            BufferedReader inFiles = new BufferedReader(new InputStreamReader(new FileInputStream(MergePath), StandardCharsets.UTF_8));

            String line = "";
            while((line = inFiles.readLine()) != null){
                test_line.add(line);
            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.            
            inFiles.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }
        return file_name_path;
        
    }
    
}
