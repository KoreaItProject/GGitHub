package com.ggit.vo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Component
public class PullreqVo {
    int idx;

    int repo;

    int member;

    String message;

    String token;

    Timestamp date;

    Integer marged;

    
}
