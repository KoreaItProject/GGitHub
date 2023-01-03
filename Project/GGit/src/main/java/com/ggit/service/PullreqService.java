package com.ggit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggit.db.mapper.PullreqMapper;
import com.ggit.vo.PullreqVo;
import com.ggit.vo.RepoVo;
import com.ggit.vo.RepomemVo;

@Service
public class PullreqService {

    @Autowired
    RepoVo repoVo;

    @Autowired
    RepomemVo repomemVo;

    @Autowired
    public PullreqMapper mapper;

    public List<PullreqVo> pullreq(){
        return mapper.pullreq();
    }

    public List<PullreqVo> pullreq_select(int idx){
        return mapper.pullreq_select(idx);
    }

    public List<PullreqVo> pullreq_select_mem(int idx){
        return mapper.pullreq_select_mem(idx);
    }

    // 저장소 멤버인지 확인
    public RepomemVo repoInMem(RepoVo repoVo){
        return mapper.repoInMem(repoVo);
    }

    public int pullrequest(RepoVo repoVo){
        return mapper.pullrequest(repoVo);
    }
}
