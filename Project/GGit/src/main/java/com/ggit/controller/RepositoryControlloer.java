package com.ggit.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ggit.service.RepoService;
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

    @Value("${storage_dir}")
    String storage_dir;

    @RequestMapping("/myRepositories")
    public List<RepositoriesVO> myRepositories(String nick) {

        List<RepositoriesVO> repositories = repoService.selectRepositories(nick);
        return repositories;
    }

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

    @RequestMapping("/getFileNames")
    public List<StorageVo> getFileNames(int repoIdx, String token, String path) {

        if (path == null) {
            path = "";
        }
        List list = new ArrayList<StorageVo>();
        File folder = new File(storage_dir + "/repositorys/" + repoIdx + "/" + token + "/" + path);
        File files[] = folder.listFiles();

        for (int i = 0; i < files.length; i++) {
            StorageVo file = new StorageVo();
            file.setName(files[i].getName());

            file.setDirectory(files[i].isDirectory());
            list.add(file);

        }
        return list;
    }

}
