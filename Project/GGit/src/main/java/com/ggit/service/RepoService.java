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

    public int nameForIdx(Map map) {
        return mapper.nameForIdx(map);
    }

    public RepositoriesVO clone(String clone) {
        return mapper.clone(clone);
    }

    public RepositoriesVO pulltoken(Map map) {
        return mapper.pulltoken(map);
    }

    public int checkRepo(Map map) {
        return mapper.checkRepo(map);
    }

    public int createRepo(RepoVo RepoVo) {
        return mapper.createRepo(RepoVo);
    }

    public List<RepositoriesVO> selectHistory(Map map) {
        return mapper.selectHistory(map);
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

    public RepositoriesVO selectRepositoryMyCode(Map map) {
        return mapper.selectRepositoryMyCode(map);
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

    public List<RepositoriesVO> selectRepoClone(int repoIdx) {
        return mapper.selectRepoClone(repoIdx);
    }

    public int repo_rename(RepoVo repovo) {
        return mapper.repo_rename(repovo);
    }

    public RepoVo getrepomessage(RepoVo repovo) {
        return mapper.getrepomessage(repovo);
    }

    // 저장소 소개글 업데이트
    public int repo_remessage_func(RepoVo repovo) {
        return mapper.repo_remessage_func(repovo);
    }

    // 저장소 이름으로 저장소 존재 여부 확인
    public int find_repo(String name) {
        return mapper.find_repo(name);
    }

    // 저장소에 속해있는지 확인
    public RepoVo repoMemCheck(RepoVo repoVo) {
        return mapper.repoMemCheck(repoVo);
    }

    
}
