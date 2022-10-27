package com.ggit.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ggit.vo.MemberVo;

/**
 * MemberMapper
 */

@Repository
@Mapper
public interface MemberMapper {

        List<MemberVo> member();

        MemberVo memberByemailPW(String email, String pw);

}
