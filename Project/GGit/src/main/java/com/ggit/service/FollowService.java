package com.ggit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggit.db.mapper.FollowMapper;
import com.ggit.vo.FollowVo;

@Service
public class FollowService {
    @Autowired
    public FollowMapper mapper;

    public List<FollowVo> follow(){
        return mapper.follow();
    }
}
