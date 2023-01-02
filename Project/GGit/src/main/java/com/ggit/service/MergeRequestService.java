package com.ggit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggit.db.mapper.MergeRequestMapper;
import com.ggit.vo.RepoVo;
import com.ggit.vo.RepomemVo;

@Service
public class MergeRequestService {

    @Autowired
    RepoVo repoVo;

    @Autowired
    RepomemVo repomemVo;

    @Autowired
    MergeRequestMapper mapper;

    public RepomemVo repoInMem(RepoVo repoVo){
        return mapper.repoInMem(repoVo);
    }


}
