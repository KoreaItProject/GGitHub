package com.ggit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggit.service.MemberService;
import com.ggit.vo.MemberVo;

@RestController
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping("/hasNick")
    public boolean hasNick(String nick) {
        return memberService.hasNick(nick);
    }

    @RequestMapping("/nickFromIdx")
    public String nickFromIdx(int idx) {

        return memberService.nickFromIdx(idx);
    }

    @RequestMapping("/memberByNick")
    public MemberVo memberByNick(String nick) {

        return memberService.memberByNick(nick);
    }

    @RequestMapping("/imgFromIdx")
    public String imgFromIdx(int idx) {

        return memberService.imgFromIdx(idx);
    }

    @RequestMapping("/imgFromNick")
    public String imgFromNick(String nick) {

        return memberService.imgFromNick(nick);
    }

    @RequestMapping("/saveProfile")
    public void saveProfile(MemberVo memberVo) {
        memberService.saveProfile(memberVo);
    }
}
