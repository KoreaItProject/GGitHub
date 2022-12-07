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

    public List<MemberVo> selectfollowlist(String nick){
        return mapper.selectfollowlist(nick);
    }
    public List<MemberVo> selectfollowinglist(String nick){
        return mapper.selectfollowinglist(nick);
    }
    public int insertFollow(String nick, int idx){
        return mapper.insertFollow(nick, idx);
    }
    public int selectfollowcount(int idx,String nick){
        return mapper.selectfollowcount(idx, nick);
    }
}
