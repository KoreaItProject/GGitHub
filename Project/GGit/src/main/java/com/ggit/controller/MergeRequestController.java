package com.ggit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggit.vo.RepoVo;

@RestController
public class MergeRequestController {
    
    @Autowired
    RepoVo repoVo;

    @RequestMapping("merge_request")
    public void merge_request(@RequestBody RepoVo repoVo){
        // 저장소 idx와 user idx를 가지고 
        // 저장소에 속한 멤버이면 : 저장소 멤버 병합 요청 후 ~병합
        // 저장소에 속하지 않은 멤버이면 : 병합 요청만 ~되고 저장소 주인 또는 권한이 있는 멤버가 병합 가능
        
        

        
    }
}
