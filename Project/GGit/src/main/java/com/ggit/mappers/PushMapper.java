package com.ggit.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ggit.vo.PushVo;

@Repository
@Mapper
public interface PushMapper {

    void push(PushVo pushVo);

    void delsel(Map map);

    void insel(String token);
}
