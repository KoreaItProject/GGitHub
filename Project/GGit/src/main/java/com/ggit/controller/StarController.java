package com.ggit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggit.service.StarService;
import com.ggit.vo.StarVo;

@RestController
public class StarController {

    @Autowired
    StarVo starVo;

    @Autowired
    StarService starService;

    @RequestMapping("selectStarlist")
    public List<StarVo> selectStarlist(String nick, int idx){
       

        List<StarVo> Starlist = starService.selectStarlist(nick, idx);
        return Starlist;
    }

    @RequestMapping("selectstarcount")
    public int selectstarcount(String reponame, int idx){
        int selectstarcount = starService.selectstarcount(reponame, idx);
        return selectstarcount;
    }
    @RequestMapping("insertStar")
    public int insertStar(String reponame, int idx){
        
        int insertStar = starService.insertStar(reponame, idx);
        return 1;
    }

    @RequestMapping("deleteStar")
    public int deleteStar(String reponame, int idx){
        System.out.println(reponame);
        System.out.println(idx);
        int deleteStar = starService.deleteStar(reponame, idx);
        return 1;
    }
    

    
   

    
}
