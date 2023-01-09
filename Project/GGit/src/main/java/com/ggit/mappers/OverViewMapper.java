package com.ggit.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ggit.vo.MemberVo;
import com.ggit.vo.OverViewVo;

@Repository
@Mapper
public interface OverViewMapper {
    String getUserIdx(String nick);

    List<OverViewVo> getContributionData(String idx);

    int pinClick(OverViewVo overViewVo);

    OverViewVo pinCheck(OverViewVo overViewVo);

    int pinClickOff(OverViewVo overViewVo);

    List<OverViewVo> getMyPin(OverViewVo overViewVo);

    void pinSortUpdate(OverViewVo overViewVo);
}
