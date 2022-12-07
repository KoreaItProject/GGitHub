package com.ggit.db.mapper;

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
}
