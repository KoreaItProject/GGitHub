package com.ggit.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggit.mappers.PushMapper;
import com.ggit.vo.PushVo;

@Service
public class PushService {

    @Autowired
    public PushMapper mapper;

    public void push(PushVo pushVo) {
        mapper.push(pushVo);
    }

    public void delsel(Map map) {
        mapper.delsel(map);
    }

    public void insel(String token) {
        mapper.insel(token);
    }

}
