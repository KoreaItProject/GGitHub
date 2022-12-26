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


    @RequestMapping("getContributionData")
    public List<OverViewVo> getContributionData(@RequestBody OverViewVo overViewVo){
        String idx = overViewService.getUserIdx(overViewVo);
        return overViewService.getContributionData(idx);
    }

    @RequestMapping("getUserIdx")
    public String getUserIdx(@RequestBody OverViewVo overViewVo){
        return overViewService.getUserIdx(overViewVo);
    }

    // 저장소 pin 클릭시 유저 정보와 저장소정보를 insert
    @RequestMapping("pinClick")
    public int pinClick(@RequestBody OverViewVo overViewVo) {
        return overViewService.pinClick(overViewVo);
    }

    // 고정이 되어있는 저장소인지 조회
    @RequestMapping("pinCheck")
    public OverViewVo pinCheck(@RequestBody OverViewVo overViewVo){
        return overViewService.pinCheck(overViewVo);
    }

    // pin 체크 해제(고정 해체)
    @RequestMapping("pinClickOff")
    public int pinCheckOff(@RequestBody OverViewVo overViewVo){
        return overViewService.pinClickOff(overViewVo);
    }

    // pin 데이터
    @RequestMapping("getMyPin")
    public List<OverViewVo> getMyPin(@RequestBody OverViewVo overViewVo){
        return overViewService.getMyPin(overViewVo);
    }

    @RequestMapping("/pinSort")
    public void repoSort(@RequestBody PinSortData pinsSortData) {
        
    
        List<OverViewVo> list = pinsSortData.getpinsdata();
        //System.out.println(list);

        int u_idx = pinsSortData.getIdx();
        //System.out.println("idx: " + u_idx);

        for (int i = 0; i < list.size(); i++) {

            overViewVo.setU_idx(u_idx);
            overViewVo.setSort_idx(i);
            overViewVo.setIdx(list.get(i).getIdx());
            overViewService.pinSortUpdate(overViewVo);

        }

    }
}

class PinSortData {
    private int idx;
    public List<OverViewVo> pins;

    public int getIdx() {
        return idx;
    }

    public List<OverViewVo> getpinsdata() {
        return pins;
    }
}
