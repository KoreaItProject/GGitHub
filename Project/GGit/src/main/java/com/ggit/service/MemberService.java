package com.ggit.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggit.mappers.MemberMapper;
import com.ggit.vo.MemberVo;
import com.ggit.vo.RepositoriesVO;

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

    public int countMember(String search) {
        return mapper.countMember(search);
    }

    public List<RepositoriesVO> searchMember(Map<String, String> map) {
        return mapper.searchMember(map);
    }

    public List<RepositoriesVO> searchMembernick(String search){
        return mapper.searchMembernick(search);
    }
}
