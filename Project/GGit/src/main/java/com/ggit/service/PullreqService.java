package com.ggit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggit.db.mapper.PullreqMapper;
import com.ggit.vo.PullreqVo;

@Service
public class PullreqService {
    @Autowired
    public PullreqMapper mapper;

    public List<PullreqVo> pullreq(){
        return mapper.pullreq();
    }
}
