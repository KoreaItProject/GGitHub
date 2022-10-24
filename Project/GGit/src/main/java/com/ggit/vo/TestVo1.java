package com.ggit.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TestVo1 {
    private String name;
    
    private String email;
    
    private String id;

    private String pwd;

    private int age;

    private int idx;
    
    public TestVo1(int idx, String name, int age, String id, String pwd, String email) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.age = age;
        this.idx = idx;
        this.id =id;
    }

    
    
}
