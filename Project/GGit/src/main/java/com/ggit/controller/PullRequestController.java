package com.ggit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ggit.service.PullreqService;
import com.ggit.vo.PullreqVo;
import com.ggit.vo.RepoVo;

@RestController
public class PullRequestController {
    
    @Autowired
    RepoVo repoVo;

    @Autowired
    PullreqService pullreqService;


    @RequestMapping("merge_request")
    public void merge_request(@RequestBody RepoVo repoVo){
        // 저장소 idx와 user idx를 가지고 
        // 저장소에 속한 멤버이면 : 저장소 멤버 병합 요청 후 ~병합
        // 저장소에 속하지 않은 멤버이면 : 병합 요청만 ~되고 저장소 주인 또는 권한이 있는 멤버가 병합 가능

        // 저장소에 속해 있는지 확인
        //System.out.println("==>" + pullreqService.repoInMem(repoVo));
        if(pullreqService.repoInMem(repoVo) == null){ // 저장소 멤버가 아닐때
            //System.out.println("저장소 멤버아님");
        }else{ // 저장소 멤버일때
            //System.out.println("==>" + repoVo);
           pullreqService.pullrequest(repoVo);
        }
    }

    // 저장소 idx로 병합요청 조회
    @RequestMapping("pullreq_select")
    public List<PullreqVo> pullreq_select(@RequestBody PullreqVo pullreqVo) {
        return pullreqService.pullreq_select(pullreqVo.getIdx());
    }

    // 저장소 idx로 병합요청(멤버) 조회
    @RequestMapping("pullreq_select_mem")
    public List<PullreqVo> pullreq_select_mem(@RequestBody PullreqVo pullreqVo) {
        return pullreqService.pullreq_select_mem(pullreqVo.getIdx());
    }
    
}
