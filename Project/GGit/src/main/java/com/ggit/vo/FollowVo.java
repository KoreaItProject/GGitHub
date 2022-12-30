package com.ggit.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class FollowVo {
    // follow
    private int follow_idx;
    private int follow_member;
    private int follow_follower;

}
