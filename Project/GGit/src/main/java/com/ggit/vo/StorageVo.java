package com.ggit.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class StorageVo {
    String name;
    boolean isDirectory;
    String commit;
    String state;
    String date;
    String content;
}
