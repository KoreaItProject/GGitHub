package com.ggit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ggit.service.MemberService;
import com.ggit.vo.MemberVo;
import com.ggit.vo.RepositoriesVO;

@RestController
public class MainController {
    @Autowired
    MemberService memberService;

    @GetMapping(value = "/hello")
    public String helloWorld() {
        return "hello world!";
    }

    @GetMapping("/login.do")
    public String main() {
        return "/view/index.html";
    }

    @PostMapping("/overview")
    @ResponseBody
    public void overview(@RequestBody MemberVo membervo) {
        System.out.println("asdasd");
        System.out.println("========>" + membervo.getIdx());
        // return memberVo = memberService.memberByemailPw(membervo);
    }

    @RequestMapping("/hasNick")
    public boolean hasNick(String nick) {
        return memberService.hasNick(nick);
    }
}
