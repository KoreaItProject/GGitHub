package com.ggit.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ggit.vo.MemberVo;

@Repository
@Mapper
public interface SettingMapper {

    MemberVo setting_check_pw(MemberVo membervo);

}
