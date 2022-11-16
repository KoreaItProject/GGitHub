package com.ggit.db.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ggit.vo.RepoVo;
import com.ggit.vo.RepositoriesVO;

@Repository
@Mapper
public interface RepoMapper {
    List<RepoVo> repo();

    List<RepositoriesVO> selectRepositories(String nick);

    RepositoriesVO selectRepositorycode(Map map);

}
