package com.ggit.vo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PullreqVo {
    int idx;

    int repo;

    int member;

    String message;

    String token;

    Timestamp date;

    Integer marged;

    public PullreqVo(int idx, int repo, int member, String message, String token, Timestamp date, Integer marged) {
        this.idx = idx;
        this.repo = repo;
        this.member = member;
        this.message = message;
        this.token = token;
        this.date = date;
        this.marged = marged;
    }

    
}
