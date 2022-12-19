package com.ggit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ggit.service.SettingService;
import com.ggit.vo.MemberVo;

@RestController
public class SettingController {

    @Autowired
    MemberVo membervo;

    @Autowired
    SettingService settingService;

    // 계정 탭 비밀번호 확인
    @RequestMapping("/setting_check_pw")
    public MemberVo setting_check_pw(@RequestBody MemberVo membervo){
        
        return settingService.setting_check_pw(membervo);
    }

    // GGit 유저 탈퇴
    @RequestMapping("/user_del")
    public int user_del(@RequestBody MemberVo memvervo){
        
        return settingService.user_del(memvervo);
    }

    // 계정 탭 비밀번호 변경
    @RequestMapping("/user_pw_update")
    public int user_pw_update(@RequestBody MemberVo membervo){
        return settingService.user_pw_update(membervo);
    }

}
