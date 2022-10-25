package com.ggit.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * BranchVo
 */

 @Getter
 @Setter
 
public class BranchVo {

    int idx;

    int repo;

    Integer post;

    String name;

    public BranchVo(int idx, int repo, Integer post, String name) {
        this.idx = idx;
        this.repo = repo;
        this.post = post;
        this.name = name;
    }

    
}