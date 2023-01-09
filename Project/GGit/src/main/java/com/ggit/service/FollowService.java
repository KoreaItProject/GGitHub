package com.ggit.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggit.mappers.FollowMapper;
import com.ggit.vo.FollowVo;
import com.ggit.vo.MemberVo;
import com.ggit.vo.RepositoriesVO;

@Service
public class FollowService {
    @Autowired
    public FollowMapper mapper;

    public List<FollowVo> follow() {
        return mapper.follow();
    }

    public List<MemberVo> selectfollowerlist(String nick, int idx) {
        return mapper.selectfollowerlist(nick, idx);
    }

    public List<MemberVo> selectfollowinglist(String nick, int idx) {
        return mapper.selectfollowinglist(nick, idx);
    }

    public int insertFollow(String nick, int idx) {

        return mapper.insertFollow(nick, idx);
    }

    public int selectfollowcount(int idx, String nick) {
        return mapper.selectfollowcount(idx, nick);
    }

    public int deletefollowlist(int idx, String nick) {

        return mapper.deletefollowlist(idx, nick);
    }

    public List<RepositoriesVO> followinglist(Map<String, String> map) {
        return mapper.followinglist(map);
    }

    public List<RepositoriesVO> followerlist(Map<String, String> map) {
        return mapper.followerlist(map);
    }

    public RepositoriesVO followCount(String nick) {
        return mapper.followCount(nick);
    }

}
