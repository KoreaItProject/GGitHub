package com.ggit.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ggit.vo.StarVo;

@Repository
@Mapper
public interface StarMapper {
    public List<StarVo> star();
}