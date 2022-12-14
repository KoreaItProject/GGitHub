package com.ggit.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ggit.vo.FollowVo;
import com.ggit.vo.MemberVo;

@Repository
@Mapper
public interface FollowMapper {
    List<FollowVo> follow();

    List<MemberVo> selectfollowerlist(String nick,int idx);

    List<MemberVo> selectfollowinglist(String nick, int idx);

    int insertFollow(String nick, int idx);

    int selectfollowcount(int idx, String nick);

    int deletefollowlist(int idx, String nick);

    List<MemberVo> followinglist(String nick);

    List<MemberVo> followerlist(String nick);
}
