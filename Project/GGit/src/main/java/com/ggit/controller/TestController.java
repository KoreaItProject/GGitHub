package com.ggit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ggit.service.TestService;
import com.ggit.vo.TestVo;
import com.ggit.vo.TestVo1;

@RestController
@RequestMapping("/")
public class TestController {
    private List<TestVo> friends;
  @Autowired
  TestService testService;

    public TestController() {
        friends = new ArrayList<>();
        friends.add(new TestVo("nicoll", "Stepane Nicoll"));
        friends.add(new TestVo("woojung", "Jeon Woojung"));
    }

    @GetMapping("/")
    public List<TestVo> list() {
        return friends;
    }

    @GetMapping("/{id}")
    public TestVo get(@PathVariable String id) {
        return friends.stream().filter(f -> id.equals(f.getId())).findAny().orElse(null);
    }

    @PostMapping("/post")
    public String PostTest(@RequestBody String msg) {
        return "post success!!!" + msg;
    }

    @RequestMapping(value="/test")
    public List<TestVo1> test() throws Exception{
       

        List<TestVo1> testList = testService.selectTest();
      

        return testList;
    }
   

    
}
