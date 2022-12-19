package com.ggit.vo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Component
public class PushVo {

    String token;

    int member;

    int repo;

    String message;

    Timestamp date;

    int branch;

    String before_token;

    int selected;

}
