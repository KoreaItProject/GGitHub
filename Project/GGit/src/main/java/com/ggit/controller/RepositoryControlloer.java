package com.ggit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ggit.service.RepoService;
import com.ggit.vo.RepositoriesVO;

@RestController
public class RepositoryControlloer {

    @Autowired
    RepositoriesVO repositoriesVO;

    @Autowired
    RepoService repoService;

    @RequestMapping("myRepositories")
    public List<RepositoriesVO> myRepositories(String nick) {
        System.out.println(nick);
        List<RepositoriesVO> repositories = repoService.selectRepositories(nick);
        return repositories;
    }

    @RequestMapping("repoIdxByNickName")
    public int repoIdxByNickName(String nick, String reponame){
        System.out.println(nick);
        System.out.println(reponame);
        Map<String, String> map = new HashMap<String, String>();
        map.put("nick",nick);
        map.put("reponame",reponame);
        int repoIdxByNickName = repoService.repoIdxByNickName(map);
        return repoIdxByNickName;


    }
    @RequestMapping("selectRepositorycode")
    public RepositoriesVO selectRepositorycode(int repoIdx){
        System.out.println(repoIdx);
        RepositoriesVO Repositorycode = repoService.selectRepositorycode(repoIdx);
        return Repositorycode;
    }

    @RequestMapping("selectRepositorycontributors")
    public List<RepositoriesVO> selectRepositorycontributors(int repoIdx){
        System.out.println(repoIdx);
        List<RepositoriesVO> Repositorycontributors = repoService.selectRepositorycontributors(repoIdx);
        return Repositorycontributors;
    }

    

   
}
