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

    public List<RepositoriesVO> selectRepositories(String nick) {
        return mapper.selectRepositories(nick);
    }

    public RepositoriesVO selectRepositorycode(Map map){

        return mapper.selectRepositorycode(map);
    }

}
