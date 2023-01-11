package com.ggit.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ggit.vo.FollowVo;
import com.ggit.vo.MemberVo;
import com.ggit.vo.RepositoriesVO;

@Repository
@Mapper
public interface FollowMapper {
    List<FollowVo> follow();

    List<MemberVo> selectfollowerlist(String nick, int idx);

    List<MemberVo> selectfollowinglist(String nick, int idx);

    int insertFollow(String nick, int idx);

    int selectfollowcount(int idx, String nick);

    int deletefollowlist(int idx, String nick);

    List<RepositoriesVO> followinglist(Map<String, String> map);

    List<RepositoriesVO> followerlist(Map<String, String> map);

    RepositoriesVO followCount(String nick);
}
