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

    int repoIdxByNickName(Map map);

    RepositoriesVO clone(Map map);

    RepositoriesVO selectRepositorycode(int repoIdx);

    RepositoriesVO selectRepositoryMyCode(Map map);

    List<RepositoriesVO> selectRepositorycontributors(int repoIdx);

    List<RepositoriesVO> selectRepositorystar(int repoIdx);

    int selectRepositorycount(String nick);

    int selectRepositorystarcount(String nick);

    List<RepositoriesVO> selectRepoClone(int repoIdx);

    int createRepo(RepoVo repoVo);

    int repo_rename(RepoVo repoVo);

}
