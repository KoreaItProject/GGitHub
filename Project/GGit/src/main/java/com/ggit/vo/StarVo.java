package com.ggit.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class StarVo {

    // star
    private int star_idx;
    private int star_repo;
    private int star_member;
    private int star_count;
    private int isMy;

    // member
    private String member_nick;

    // repo
    private String repo_name;

    // push
    private String push_date;

}
