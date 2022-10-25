package com.ggit.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StarVo {
    
    int idx;

    int repo;

    int member;

    public StarVo(int idx, int repo, int member) {
        this.idx = idx;
        this.repo = repo;
        this.member = member;
    }
}
