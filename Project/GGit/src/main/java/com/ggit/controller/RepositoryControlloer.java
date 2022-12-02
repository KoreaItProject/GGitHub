package com.ggit.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;
import com.ggit.service.RepoService;
import com.ggit.service.RepomemService;
import com.ggit.util.RandStr;
import com.ggit.vo.RepoVo;
import com.ggit.vo.RepomemVo;
import com.ggit.vo.RepositoriesVO;
import com.ggit.vo.StorageVo;

@RestController
public class RepositoryControlloer {

    @Autowired
    RepositoriesVO repositoriesVO;
    @Autowired
    RepoService repoService;
    @Autowired
    StorageVo storageVo;
    @Autowired
    RepoVo repoVo;
    @Autowired
    RepomemVo repomemVo;
    @Autowired
    RepomemService repomemService;

    @Value("${storage_dir}")
    String storage_dir;

    @RequestMapping("/createRepo")
    public int createRepo(@RequestBody String data) {
        // 저장소를 만들면 푸쉬가 한번 돼야한다
        // 저장소 만든 오너도 repomem에 넣어야한다 sort = 0
        //

        try {

            JSONObject jsonObject = (JSONObject) new JSONParser().parse(data);

            String repoName = (String) jsonObject.get("repoName");
            String description = (String) jsonObject.get("description");
            int pub = Integer.parseInt(jsonObject.get("pub") + "");
            boolean readme = (boolean) jsonObject.get("readme");
            int owner = Integer.parseInt(jsonObject.get("owner") + "");

            repoVo.setName(repoName);
            repoVo.setDescription(description);
            repoVo.setPubl(pub);
            repoVo.setOwner(owner);
            repoVo.setClone(new RandStr(35).getResult());
            repoService.createRepo(repoVo);
            repomemVo.setMember(owner);
            repomemVo.setRepo(repoVo.getIdx());
            repomemService.join(repomemVo);

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            return 0;
        }

        return 1;
    }

    @RequestMapping("/myRepositories")
    public List<RepositoriesVO> myRepositories(String nick) {

        List<RepositoriesVO> repositories = repoService.selectRepositories(nick);
        return repositories;
    }

    @RequestMapping("/repoSort")
    public void repoSort(@RequestBody List<RepositoriesVO> Repo) {
        for (int i = 0; i < Repo.size(); i++) {
            System.out.println("sort = " + i + " repo = " + Repo.get(i).getRepo_idx());
        }
        System.out.println("==========================");

    }
    // @Transactional
    // @PutMapping("/repoSortUpdate")
    // public RepositoriesVO repoSortUpdate(@PathVariable int idx, @RequestBody
    // List<RepositoriesVO> Repo){
    // for(int i=0; i< Repo.size(); i++){
    // RepositoriesVO.setSort(requestRepositoriesVO.getSort());
    // RepositoriesVO.setRepo(requestRepositoriesVO.getRepo());

    // }
    // }

    @RequestMapping("/repoIdxByNickName")
    public int repoIdxByNickName(String nick, String reponame) {
        int repoIdxByNickName;
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put("nick", nick);
            map.put("reponame", reponame);
            repoIdxByNickName = repoService.repoIdxByNickName(map);

        } catch (Exception e) {
            return 0;
        }
        return repoIdxByNickName;

    }

    @RequestMapping("/selectRepositorycode")
    public RepositoriesVO selectRepositorycode(int repoIdx) {

        RepositoriesVO Repositorycode = repoService.selectRepositorycode(repoIdx);
        return Repositorycode;
    }

    @RequestMapping("/selectRepositorycontributors")
    public List<RepositoriesVO> selectRepositorycontributors(int repoIdx) {

        List<RepositoriesVO> Repositorycontributors = repoService.selectRepositorycontributors(repoIdx);
        return Repositorycontributors;
    }

    @RequestMapping("/selectRepositorystar")
    public List<RepositoriesVO> selectRepositorystar(int repoIdx) {

        List<RepositoriesVO> Repositorystar = repoService.selectRepositorystar(repoIdx);
        return Repositorystar;
    }

    @RequestMapping("/getFile")
    public List<StorageVo> getFile(int repoIdx, String token, String path) {

        if (path == null) {
            path = "";
        }
        String filePath = storage_dir + "/repositorys/" + repoIdx + "/" + token + "/" + path;
        List list = new ArrayList<StorageVo>();
        File folder = new File(filePath);
        File files[] = folder.listFiles();

        if (folder.isFile()) {
            StorageVo file = new StorageVo();
            String content = "";
            content = fileLeader(filePath, file);
            file.setState("file");
            file.setContent(content);
            file.setName(folder.getName());
            list.add(file);

            return list;
        }
        try {
            for (int i = 0; i < files.length; i++) {
                StorageVo file = new StorageVo();
                if (files[i].getName().equals("README.md")) {
                    file.setState("readme");
                    String content = "";
                    content = fileLeader(filePath + "/README.md", file);
                    file.setContent(content);
                }
                file.setName(files[i].getName());
                file.setDirectory(files[i].isDirectory());
                list.add(file);

            }
        } catch (NullPointerException e) {
            System.out.println("파일없음");
        }

        return list;
    }

    public String fileLeader(String filePath, StorageVo file) {
        String content = "";
        BufferedReader reader;
        int count = 0;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(
                            filePath), "UTF-8"));
            String str;

            while ((str = reader.readLine()) != null) {
                content += str + "\n";
                count++;
            }
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        file.setTotalLine(count);

        return content;
    }

    @RequestMapping("selectRepositorycount")
    public int selectRepositorycount(String nick) {
        int Repositorycount = repoService.selectRepositorycount(nick);
        return Repositorycount;

    }

    @RequestMapping("selectRepositorystarcount")
    public int selectRepositorystarcount(String nick) {
        int Repositorystarcount = repoService.selectRepositorystarcount(nick);
        return Repositorystarcount;
    }

    @RequestMapping("selectRepoClone")
    public List<RepositoriesVO> selectRepoClone(int repoIdx) {
        System.out.println(repoIdx);
        List<RepositoriesVO> RepoClone = repoService.selectRepoClone(repoIdx);
        return RepoClone;
    }

}
