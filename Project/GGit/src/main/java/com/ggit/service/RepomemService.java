package com.ggit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggit.db.mapper.RepomemMapper;
import com.ggit.vo.RepomemVo;

@Service
public class RepomemService {
    
    @Autowired
    public RepomemMapper mapper;

    public List<RepomemVo> repomem(){
        return mapper.repomem();
    }
}