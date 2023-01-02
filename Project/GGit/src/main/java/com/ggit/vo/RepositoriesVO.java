package com.ggit.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class RepositoriesVO {

    // repo
    private int repo_idx;
    private String repo_name;
    private String repo_createDate;
    private int repo_publ;
    private int repo_owner;
    private int repo_fork;
    private int repo_count;
    private String repo_clone;
    private String description;
    private int repo_download;

    // repomem
    private int repomem_idx;
    private int repomem_repo;
    private int repomem_member;
    private int repomem_sort;

    // member
    private int member_idx;
    private String member_nick;
    private String member_email;
    private String member_pw;
    private String member_img;
    private int member_auth;
    private String member_date;

    // push
    private String push_message;
    private String push_token;
    private String push_date;
    private int selected;
    private String before_token;
    private int fromMain = 0;
    // 커밋수
    private int commits;

    // star

    private int star_idx;
    private int star_repo;
    private int star_member;
    private int star_count;

    // follow
    private int followingCount;
    private int followerCount;
    // 검색기능에서 사용
    private String s_nick, s_name, s_description;

}
