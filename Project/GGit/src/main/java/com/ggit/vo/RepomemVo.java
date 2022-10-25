package com.ggit.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RepomemVo {

        int idx;

        int repo;

        int member;

        public RepomemVo(int idx, int repo, int member) {
            this.idx = idx;
            this.repo = repo;
            this.member = member;
        }

        
}
