package com.ggit.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ggit.vo.RepomemVo;

@Repository
@Mapper
public interface RepomemMapper {
    List<RepomemVo> repomem();

    void join(RepomemVo repomemVo);

}
