package com.ggit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ggit.service.BranchService;
import com.ggit.service.FollowService;
import com.ggit.service.MemberService;
import com.ggit.service.PullreqService;
import com.ggit.service.PushService;
import com.ggit.service.RepoService;
import com.ggit.service.RepomemService;
import com.ggit.service.StarService;

import com.ggit.vo.BranchVo;
import com.ggit.vo.FollowVo;
import com.ggit.vo.MemberVo;
import com.ggit.vo.PullreqVo;
import com.ggit.vo.PushVo;
import com.ggit.vo.RepoVo;
import com.ggit.vo.RepomemVo;
import com.ggit.vo.StarVo;

@RestController
public class TestController {

    @Autowired
    MemberService memberService;
    @Autowired
    RepoService repoService;
    @Autowired
    BranchService branchService;
    @Autowired
    FollowService followService;
    @Autowired
    PullreqService pullreqService;
    @Autowired
    PushService pushService;
    @Autowired
    RepomemService repomemService;
    @Autowired
    StarService starService;

    @PostMapping("/post")
    public String PostTest(@RequestBody String msg) {
        return "post success!!!" + msg;
    }

    @RequestMapping(value = "/member")
    public List<MemberVo> member() throws Exception {

        List<MemberVo> memList = memberService.member();

        return memList;
    }

    @RequestMapping(value = "/repo")
    public List<RepoVo> repo() throws Exception {

        System.out.println(1234);
        List<RepoVo> repoList = repoService.repo();

        return repoList;
    }

    @RequestMapping(value = "/branch")
    public List<BranchVo> branch() throws Exception {

        List<BranchVo> branchList = branchService.branch();

        return branchList;
    }

    @RequestMapping(value = "/follow")
    public List<FollowVo> follow() throws Exception {

        List<FollowVo> followList = followService.follow();

        return followList;
    }

    @RequestMapping(value = "/pullreq")
    public List<PullreqVo> pullreq() throws Exception {

        List<PullreqVo> pullreqList = pullreqService.pullreq();

        return pullreqList;
    }

    @RequestMapping(value = "/repomem")
    public List<RepomemVo> repomem() throws Exception {

        List<RepomemVo> repomemList = repomemService.repomem();
        return repomemList;

    }

    @RequestMapping(value = "/star")
    public List<StarVo> star() throws Exception {

        List<StarVo> starList = starService.star();
        return starList;

    }
}
