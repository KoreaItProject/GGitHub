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

    public List<StarVo> selectStarlist(String nick, int idx){
        return mapper.selectStarlist(nick, idx);
    }
    public int selectstarcount(String reponame, int idx){
        return mapper.selectstarcount(reponame, idx);
    }
    public int insertStar(String reponame, int idx){
        return mapper.insertStar(reponame, idx);
    }
    public int deleteStar(String reponame, int idx){
        return mapper.deleteStar(reponame, idx);
    }
    
}
