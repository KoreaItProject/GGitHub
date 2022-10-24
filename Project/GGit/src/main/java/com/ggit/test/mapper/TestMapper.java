package com.ggit.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import com.ggit.vo.TestVo1;

@Repository
@Mapper
public interface TestMapper {
    
    List<TestVo1> selectTest();

}
