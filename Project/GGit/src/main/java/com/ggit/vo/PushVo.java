package com.ggit.vo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Component
public class PushVo {

    private String token;

    private int member;

    private int repo;

    private String message;

    private Timestamp date;

    private int branch;

    private String before_token;

    private int selected;

    private int fromMain = 0;

}
