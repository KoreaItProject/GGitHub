package com.ggit.vo;

import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class OverViewVo {
    private int idx; //
    private int count;//
    private int publ;//
    private int owner;//
    private int fork; //
    private int repo_idx;//
    private int u_idx;//
    private int sort_idx;//

    private String date;//
    private String nick;//
    private String name; //
    private String createDate;//
    private String repo_rename;//
    private String clone;//
    private String description; //

}
