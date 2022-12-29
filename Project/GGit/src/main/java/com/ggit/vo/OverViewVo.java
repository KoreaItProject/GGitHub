package com.ggit.vo;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class OverViewVo {
    int idx; //
    int count;//
    int publ;//
    int owner;//
    int fork; //
    int repo_idx;//
    int u_idx;//
    int sort_idx;//

    String date;//
    String nick;//
    String name; //
    String createDate;//
    String repo_rename;//
    String clone;//
    String description; //
   
}
