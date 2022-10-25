package com.ggit.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class FollowVo {

    int idx;

    int member;

    int follow;

    public FollowVo(int idx, int member, int follow) {
        this.idx = idx;
        this.member = member;
        this.follow = follow;
    }

    
    
}
