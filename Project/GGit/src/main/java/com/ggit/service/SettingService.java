package com.ggit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ggit.mappers.SettingMapper;
import com.ggit.vo.MemberVo;

@Service
public class SettingService {
    @Autowired
    MemberVo membervo;

    @Autowired
    SettingMapper mapper;

    public MemberVo setting_check_pw(MemberVo membervo) {

        return mapper.setting_check_pw(membervo);

    }

    // GGit 유저 탈퇴
    public int user_del(MemberVo membervo) {
        return mapper.user_del(membervo);
    }

    // 계정 탭 비밀번호 변경
    public int user_pw_update(MemberVo membervo) {
        return mapper.user_pw_update(membervo);
    }
}
