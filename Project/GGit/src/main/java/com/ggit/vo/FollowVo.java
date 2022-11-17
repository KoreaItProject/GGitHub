package com.ggit.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class FollowVo {

    int idx;

    int member;

    int follower;

}
