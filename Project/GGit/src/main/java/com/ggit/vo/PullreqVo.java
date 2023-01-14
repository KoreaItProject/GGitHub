package com.ggit.vo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class PullreqVo {
    private int idx;

    private int repo;

    private int member;

    private String message;

    private String token;

    private Timestamp date;

    private Integer marged;

    private int u_idx;

    private int repo_idx;

    private String nick;

    private String nowToken; // 현재 저장소의 최신 토큰 비교병합이 필요한지 여부 파악을 위해

    private String mainToken;
}
