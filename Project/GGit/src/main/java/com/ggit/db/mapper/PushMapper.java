package com.ggit.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ggit.vo.PushVo;

@Repository
@Mapper
public interface PushMapper {

    void push(PushVo pushVo);
}
