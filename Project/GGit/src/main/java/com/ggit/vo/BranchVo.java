package com.ggit.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * BranchVo
 */

@Getter
@Setter

public class BranchVo {

    private int idx;

    private int repo;

    private Integer post;

    private String name;

    public BranchVo(int idx, int repo, Integer post, String name) {
        this.idx = idx;
        this.repo = repo;
        this.post = post;
        this.name = name;
    }

}