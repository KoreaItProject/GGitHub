package com.ggit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggit.mappers.BranchMapper;
import com.ggit.vo.BranchVo;

@Service
public class BranchService {

    @Autowired
    public BranchMapper mapper;

    public List<BranchVo> branch() {
        return mapper.branch();
    }
}
