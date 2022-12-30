package com.ggit.vo;

import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@Component
public class StarVo {
    
    //star
    int star_idx;
    int star_repo;
    int star_member;
    int star_count;
    int isMy;

    //member
    String member_nick;
    
    //repo
    String repo_name;

    //push
    String push_date;
    
    
    
}
    
