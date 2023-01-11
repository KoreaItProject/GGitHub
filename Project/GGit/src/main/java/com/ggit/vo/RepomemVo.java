package com.ggit.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class RepomemVo {

    private int idx;
    private int repo;
    private int member;
    private int sort;

    private String member_nick;
    private String member_img;
    


}
