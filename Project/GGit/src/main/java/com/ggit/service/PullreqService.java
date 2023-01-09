package com.ggit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggit.mappers.PullreqMapper;
import com.ggit.vo.PullreqVo;
import com.ggit.vo.RepoVo;
import com.ggit.vo.RepomemVo;

@Service
public class PullreqService {

    @Autowired
    RepoVo repoVo;

    @Autowired
    PullreqVo pullreqVo;

    @Autowired
    RepomemVo repomemVo;

    @Autowired
    public PullreqMapper mapper;

    public List<PullreqVo> pullreq() {
        return mapper.pullreq();
    }

    public List<PullreqVo> pullreq_select(int idx) {
        return mapper.pullreq_select(idx);
    }

    public List<PullreqVo> pullreq_select_mem(int idx) {
        return mapper.pullreq_select_mem(idx);
    }

    // 저장소 멤버인지 확인
    public RepomemVo repoInMem(PullreqVo pullreqVo) {
        return mapper.repoInMem(pullreqVo);
    }

    public int pullrequest(PullreqVo pullreqVo) {
        return mapper.pullrequest(pullreqVo);
    }
}
