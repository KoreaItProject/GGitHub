package com.ggit.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggit.vo.MemberVo;

/**
 * MemberMapper
 */

@Repository
@Mapper
public interface MemberMapper {

        List<MemberVo> member();

        MemberVo memberByemailPw(MemberVo membervo);

        int hasNick(String nick);

        String nickFromIdx(int idx);

        // 회원 가입
        int signupMember(MemberVo membervo);

}
