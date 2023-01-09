package com.ggit.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ggit.vo.BranchVo;

@Repository
@Mapper
public interface BranchMapper {

    List<BranchVo> branch();

}
