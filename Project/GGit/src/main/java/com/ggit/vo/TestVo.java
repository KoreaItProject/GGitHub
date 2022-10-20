package com.ggit.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// @ToString
// @NoArgsConstructor
// @AllArgsConstructor

public class TestVo {
    private String id;
    private String name;
    private Void getId;
    private Void getName;
    private Void setId;
    private Void setName;

    public TestVo(String id, String name) {
        this.id = id;
        this.name = name;
    }
}