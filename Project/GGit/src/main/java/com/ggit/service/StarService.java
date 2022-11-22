package com.ggit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggit.db.mapper.StarMapper;
import com.ggit.vo.StarVo;

@Service
public class StarService {
    @Autowired
    public StarMapper mapper;

    public List<StarVo> star(){
        return mapper.star();
    }

    public List<StarVo> selectStarlist(String nick){
        return mapper.selectStarlist(nick);
    }
    
}
