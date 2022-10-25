package com.ggit.vo;

import java.sql.Timestamp;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RepoVo {

    int idx;

    String name;

    Timestamp createDate;

    Integer publ;

    int owner;

    Integer fork;

    public RepoVo(int idx, String name, Timestamp createDate, Integer publ, int owner, Integer fork) {
        this.idx = idx;
        this.name = name;
        this.createDate = createDate;
        this.publ = publ;
        this.owner = owner;
        this.fork = fork;
    }
   
    
    
    
}
