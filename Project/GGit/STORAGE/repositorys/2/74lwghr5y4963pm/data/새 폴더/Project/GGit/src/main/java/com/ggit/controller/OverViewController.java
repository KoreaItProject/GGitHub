package com.ggit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggit.service.OverViewService;
import com.ggit.vo.MemberVo;
import com.ggit.vo.OverViewVo;

@RestController
public class OverViewController {
    @Autowired
    MemberVo membervo;

    @Autowired
    OverViewVo overViewVo;
    
    @Autowired
    OverViewService overViewService;


    @RequestMapping("/getContributionData")
    public List<OverViewVo> getContributionData(@RequestBody OverViewVo overViewVo){
        String idx = overViewService.getUserIdx(overViewVo);
        return overViewService.getContributionData(idx);
    }
}
