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

    @RequestMapping("/setting_check_pw")
    public MemberVo setting_check_pw(@RequestBody MemberVo membervo){
        
        return settingService.setting_check_pw(membervo);
    }

}
