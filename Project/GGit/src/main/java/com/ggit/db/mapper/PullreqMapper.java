package com.ggit.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ggit.vo.PullreqVo;

@Repository
@Mapper
public interface PullreqMapper {
    


    List<PullreqVo> pullreq();

    List<PullreqVo> pullreq_select(int idx);
}
