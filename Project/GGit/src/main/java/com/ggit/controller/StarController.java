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
    public List<StarVo> selectStarlist(String nick){
        System.out.println(nick);
        List<StarVo> Starlist = starService.selectStarlist(nick);
        return Starlist;
    }

    

    
   

    
}
