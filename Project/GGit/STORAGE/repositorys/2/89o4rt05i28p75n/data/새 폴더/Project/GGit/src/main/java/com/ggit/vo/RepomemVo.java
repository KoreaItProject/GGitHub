package com.ggit.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class RepomemVo {

    int idx;
    int repo;
    int member;
    int sort;

}
