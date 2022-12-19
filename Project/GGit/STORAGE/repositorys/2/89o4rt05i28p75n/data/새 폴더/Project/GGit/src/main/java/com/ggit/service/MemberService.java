package com.ggit.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggit.db.mapper.MemberMapper;
import com.ggit.vo.MemberVo;

@Service
public class MemberService {
    @Autowired
    public MemberMapper mapper;
    @Autowired
    public MemberVo memberVo;

    public List<MemberVo> member() {
        return mapper.member();
    }

    public MemberVo memberByemailPw(MemberVo membervo) {
        return mapper.memberByemailPw(membervo);
    }

    public MemberVo memberByNick(String nick) {
        MemberVo memberVo = mapper.memberByNick(nick);
        if (memberVo.getImg() == null)
            memberVo.setImg("profileDef.png");

        return memberVo;
    }

    public boolean hasNick(String nick) {
        if (0 == mapper.hasNick(nick)) {
            return false;
        } else {
            return true;
        }

    }

    public String nickFromIdx(int idx) {
        return mapper.nickFromIdx(idx);

    }

    public String imgFromIdx(int idx) {
        String img;
        img = mapper.imgFromIdx(idx);
        if (img == null)
            img = "profileDef.png";
        return img;
    }

    public String imgFromNick(String nick) {
        String img;
        img = mapper.imgFromNick(nick);
        if (img == null)
            img = "profileDef.png";
        return img;
    }

    public int signupMember(MemberVo membervo) {
        return mapper.signupMember(membervo);

    }

    public void saveProfile(MemberVo memberVo) {
        mapper.saveProfile(memberVo);
    }

    public void saveProfileImg(Map map) {
        mapper.saveProfileImg(map);
    }

    public void delectProfileImg(int idx) {
        mapper.delectProfileImg(idx);
    }
    
    
    

}
