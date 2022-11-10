package com.ggit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ggit.socket.SocketRunTime;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "/view/login.html";
    }

    @GetMapping("/login.do")
    public String main() {
        return "/view/index.html";
    }

    @ResponseBody
    @GetMapping("/999999999")
    public String s() {
        new SocketRunTime();
        return "999999999";
    }

}
