package com.ggit.vo;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class PullreqVo2 {
    private String filePath;

    private String fileName;

    private String filestate;
    private String filestateMain;

    private ArrayList<String> fileData;

    private StringBuilder sb_vo;

    private int marginState;

    private ArrayList<String> fileDataMain;

    private StringBuilder sb_vo_main;

    private int state;
}
