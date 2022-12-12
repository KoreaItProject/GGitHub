package com.ggit.vo;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Component
public class RepositoriesVO {

    // repo
    int repo_idx;
    String repo_name;
    String repo_createDate;
    int repo_publ;
    int repo_owner;
    int repo_fork;
    int repo_count;
    String repo_clone;
    String description;

    // repomem
    int repomem_idx;
    int repomem_repo;
    int repomem_member;
    int repomem_sort;

    // member
    int member_idx;
    String member_nick;
    String member_email;
    String member_pw;
    String member_img;
    int member_auth;
    String member_date;

    // push
    String push_message;
    String push_token;
    String push_date;
    int selected;
    String before_token;
    // 커밋수
    int commits;

    // star

    int star_idx;
    int star_repo;
    int star_member;

}
