package com.ggit.vo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Component
public class RepoVo {

    private int idx;

    private String name;

    private String createDate;

    private int publ;

    private int owner;

    private int fork;
    private String repo_rename;

    private String clone;
    private String description;

    private int repo_idx;
    private int u_idx;
    private int sort_idx;

    private String token;

}
