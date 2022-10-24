package com.ggit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggit.test.mapper.TestMapper;
import com.ggit.vo.TestVo1;

@Service
public class TestService {
    @Autowired
    public TestMapper mapper;

    public List<TestVo1> selectTest(){
        return mapper.selectTest();
    }
}
