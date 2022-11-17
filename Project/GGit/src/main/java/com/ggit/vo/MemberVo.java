package com.ggit.vo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Component
public class MemberVo {
    String nick;

    String email;

    String pw;

    String img;

    int idx;

    int auth;

    String date;
    String con;
    String url;
    String company;
    String location;

    // 팔로우수
    int followers, following;
}
