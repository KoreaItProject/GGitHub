package com.ggit.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ggit.vo.MemberVo;

@Repository
@Mapper
public interface SettingMapper {

    MemberVo setting_check_pw(MemberVo membervo);

    int user_del(MemberVo membervo); // GGit 계정 탈퇴

    int user_pw_update(MemberVo membervo); // 비밀번호 변경

}
