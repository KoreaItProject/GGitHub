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

    List<MemberVo> selectfollowlist(String nick);

    List<MemberVo> selectfollowinglist(String nick);

    int insertFollow(String nick, int idx);

    int selectfollowcount(int idx, String nick);

    int deletefollowlist(int idx, String nick);
}
