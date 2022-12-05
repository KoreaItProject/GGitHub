package com.ggit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggit.db.mapper.PushMapper;
import com.ggit.vo.PushVo;

@Service
public class PushService {

    @Autowired
    public PushMapper mapper;

    public void push(PushVo pushVo) {
        mapper.push(pushVo);
    }

}
