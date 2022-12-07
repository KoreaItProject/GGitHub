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

}
