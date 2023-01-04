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
    private String nick;

    private String email;

    private String pw;

    private String img;

    private int idx;

    private int auth;

    private String date;
    private String con;
    private String url;
    private String company;
    private String location;
    private int email_check;
    private String member_img;

    // 팔로우수
    private int followers, following;
    private int follow_idx;
    // 팔로우 여부 확인
    private int count;
}
