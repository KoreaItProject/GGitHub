package com.ggit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggit.service.MemberService;

@RestController
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping("/hasNick")
    public boolean hasNick(String nick) {
        return memberService.hasNick(nick);
    }

    @RequestMapping("nickFromIdx")
    public String nickFromIdx(int idx) {

        return memberService.nickFromIdx(idx);
    }
}
