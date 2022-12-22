package com.ggit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggit.db.mapper.OverViewMapper;
import com.ggit.vo.MemberVo;
import com.ggit.vo.OverViewVo;

@Service
public class OverViewService {
    @Autowired
    public OverViewMapper mapper;

    @Autowired
    OverViewVo overViewVo;

    // 유저 idx 얻기
    public String getUserIdx(OverViewVo overViewVo){
        return mapper.getUserIdx(overViewVo.getNick());
    }

    // contribution(잔디) 데이터 얻어오기
    public List<OverViewVo> getContributionData(String idx){
        return mapper.getContributionData(idx);
    }

    // 저장소 pin 클릭시 유저 정보와 저장소 정보를 insert하자
    public int pinClick(OverViewVo overViewVo) {
        return mapper.pinClick(overViewVo);
    }

    // pin이 체크 되어있는지 아닌지 조회
    public OverViewVo pinCheck(OverViewVo overViewVo){
        return mapper.pinCheck(overViewVo);
    }

    // pin 체크 해제(고정 해체)
    public int pinClickOff(OverViewVo overViewVo){
        return mapper.pinClickOff(overViewVo);
    }

    // pin 데이터 조회
    public List<OverViewVo> getMyPin(OverViewVo overViewVo){
        return mapper.getMyPin(overViewVo);
    }

}
