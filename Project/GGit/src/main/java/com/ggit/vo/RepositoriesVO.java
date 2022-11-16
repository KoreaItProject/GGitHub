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

    // repomem
    int repomem_idx;
    int repomem_repo;
    int repomem_member;

    // member
    int member_idx;
    String member_nick;
    String member_email;
    String member_pw;
    String member_img;
    int member_auth;
    String member_date;

    //push
    String push_message;
    String push_token;
    String push_date;

    

}
