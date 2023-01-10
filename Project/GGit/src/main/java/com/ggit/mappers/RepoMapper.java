package com.ggit.mappers;

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

    int nameForIdx(Map map);

    List<RepositoriesVO> selectRepositories(String nick);

    int repoIdxByNickName(Map map);

    RepositoriesVO clone(String clone);

    RepositoriesVO pulltoken(Map map);

    RepositoriesVO selectRepositorycode(Map<String, String> map);

    RepositoriesVO selectRepositoryMyCode(Map map);

    List<RepositoriesVO> selectRepositorycontributors(int repoIdx);

    List<RepositoriesVO> selectRepositorystar(int repoIdx);

    int selectRepositorycount(Map<String, String> map);

    int selectRepositorystarcount(String nick);

    List<RepositoriesVO> selectRepoClone(int repoIdx);

    int getPublic(Map map);

    int checkRepo(Map map);

    int createRepo(RepoVo repoVo);

    List<RepositoriesVO> selectHistory(Map map);

    int repo_rename(RepoVo repoVo);

    RepoVo getrepomessage(RepoVo repoVo);

    int repo_remessage_func(RepoVo repoVo);

    int find_repo(String name);

    RepoVo repoMemCheck(RepoVo repoVo);

    List<RepositoriesVO> searchSimple(Map map);

    List<RepositoriesVO> search(Map map);

    int searchPageCount(Map map);

    void repoDown(int idx);

    void setPublic(RepoVo repoVo);

}
