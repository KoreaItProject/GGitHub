package com.ggit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ggit.service.MemberService;
import com.ggit.vo.MemberVo;

@RestController
public class LoginController {
    @Autowired
    public MemberVo memberVo;

    @Autowired
    public MemberService memberService;

    @PostMapping("/login")
    @ResponseBody
    public MemberVo login(@RequestBody MemberVo membervo) {
        return memberVo = memberService.memberByemailPw(membervo);
    }

    @PostMapping("/signup")
    @ResponseBody
    public int signup(@RequestBody MemberVo membervo) {
        return memberService.signupMember(membervo);
    }
}
