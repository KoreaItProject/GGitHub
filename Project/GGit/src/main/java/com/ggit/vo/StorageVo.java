package com.ggit.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class StorageVo {
    private String name;
    private boolean isDirectory;
    private String commit;
    private String state;
    private String date;
    private String content;
    private int totalLine;
    private String push_message;
    private String push_date;

    public boolean getDirectory() {
        return isDirectory;
    }
}
