package com.ggit.vo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PushVo {
    
    String token;

    int member;

    int repo;

    String message;

    Timestamp date;

    int branch;

    String from;

    public PushVo(String token, int member, int repo, String message, Timestamp date, int branch, String from) {
        this.token = token;
        this.member = member;
        this.repo = repo;
        this.message = message;
        this.date = date;
        this.branch = branch;
        this.from = from;
    }

    
}
