package com.ggit.vo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Component
public class RepoVo {

    int idx;

    String name;

    String createDate;

    int publ;

    int owner;

    int fork;
    String repo_rename;

    String clone;
    String description;

}
