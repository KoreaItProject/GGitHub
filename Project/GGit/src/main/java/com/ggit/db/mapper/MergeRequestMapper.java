package com.ggit.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ggit.vo.RepoVo;
import com.ggit.vo.RepomemVo;

@Repository
@Mapper
public interface MergeRequestMapper {
    RepomemVo repoInMem(RepoVo repovo);
}
