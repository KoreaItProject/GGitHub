package com.ggit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggit.db.mapper.FollowMapper;
import com.ggit.vo.FollowVo;
import com.ggit.vo.MemberVo;

@Service
public class FollowService {
    @Autowired
    public FollowMapper mapper;

    public List<FollowVo> follow(){
        return mapper.follow();
    }

    public List<MemberVo> selectfollowlist(String nick, int idx){
        return mapper.selectfollowlist(nick, idx);
    }
    public List<MemberVo> selectfollowerlist(String nick, int idx){
        return mapper.selectfollowerlist(nick, idx);
    }
    public int insertFollow(String nick, int idx){
        
        return mapper.insertFollow(nick, idx);
    }
    public int selectfollowcount(int idx,String nick){
        return mapper.selectfollowcount(idx, nick);
    }

    public int deletefollowlist(int idx, String nick){
       
        return mapper.deletefollowlist(idx, nick);
    }
    
  
}
