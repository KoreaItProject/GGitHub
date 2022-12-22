package com.ggit.vo;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class OverViewVo {
    String nick;

    int idx;

    String date;

    int count;

    String name;

    String createDate;

    int publ;

    int owner;

    int fork;
    String repo_rename;

    String clone;
    String description;

    int repo_idx;
    int u_idx;
    int sort_idx;
}
