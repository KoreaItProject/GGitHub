package com.ggit.vo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Component
public class MemberVo {
    String nick;

    String email;

    String pw;

    String img;

    int idx;

    Integer auth;

    Timestamp date;

    public MemberVo() {

    }

    public MemberVo(int idx, String nick, String email, String pw, Integer auth, Timestamp date, String img) {
        this.idx = idx;
        this.nick = nick;
        this.email = email;
        this.pw = pw;
        this.auth = auth;
        this.date = date;
        this.img = img;
    }

}
