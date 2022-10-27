package com.ggit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggit.db.mapper.MemberMapper;
import com.ggit.vo.MemberVo;

@Service
public class MemberService {
    @Autowired
    public MemberMapper mapper;

    public List<MemberVo> member() {
        return mapper.member();
    }

    public MemberVo memberByemailPW(String email, String pw) {
        return mapper.memberByemailPW(email, pw);
    }

}
