package com.ggit.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class FollowVo {
    //follow
    int follow_idx;
    int follow_member;
    int follow_follower;

}
