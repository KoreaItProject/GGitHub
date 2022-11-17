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

        MemberVo memberByNick(String nick);

        int hasNick(String nick);

        String nickFromIdx(int idx);

        String imgFromIdx(int idx);

        String imgFromNick(String nick);

        // 회원 가입
        int signupMember(MemberVo membervo);

        void saveProfile(MemberVo memberVo);

}
