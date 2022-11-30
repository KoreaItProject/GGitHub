package com.ggit.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggit.db.mapper.RepoMapper;
import com.ggit.vo.RepoVo;
import com.ggit.vo.RepositoriesVO;

@Service
public class RepoService {

    @Autowired

    public RepoMapper mapper;

    public List<RepoVo> repo() {
        return mapper.repo();
    }

    public int clone(String clone) {
        return mapper.clone(clone);
    }

    public List<RepositoriesVO> selectRepositories(String nick) {
        return mapper.selectRepositories(nick);
    }

    public int repoIdxByNickName(Map map) {

        return mapper.repoIdxByNickName(map);
    }

    public RepositoriesVO selectRepositorycode(int repoIdx) {
        return mapper.selectRepositorycode(repoIdx);
    }

    public List<RepositoriesVO> selectRepositorycontributors(int repoIdx) {
        return mapper.selectRepositorycontributors(repoIdx);
    }

    public List<RepositoriesVO> selectRepositorystar(int repoIdx) {
        return mapper.selectRepositorystar(repoIdx);
    }

    public int selectRepositorycount(String nick) {
        return mapper.selectRepositorycount(nick);
    }

    public int selectRepositorystarcount(String nick) {
       
        return mapper.selectRepositorystarcount(nick);
    }
  

}
