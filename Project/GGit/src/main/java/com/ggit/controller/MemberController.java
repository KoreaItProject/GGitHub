package com.ggit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ggit.service.FollowService;
import com.ggit.service.MemberService;
import com.ggit.vo.MemberVo;
import com.ggit.vo.RepositoriesVO;

@RestController
public class MemberController {
    @Autowired
    MemberService memberService;
    @Autowired
    FollowService followService;

    @Value("${storage_dir}")
    String storage_dir;

    @RequestMapping("/hasNick")
    public boolean hasNick(String nick) {
        return memberService.hasNick(nick);
    }

    @RequestMapping("/nickFromIdx")
    public String nickFromIdx(int idx) {

        return memberService.nickFromIdx(idx);
    }

    @RequestMapping("/memberByNick")
    public MemberVo memberByNick(String nick) {

        return memberService.memberByNick(nick);
    }

    @RequestMapping("/imgFromIdx")
    public String imgFromIdx(int idx) {

        return memberService.imgFromIdx(idx);
    }

    @RequestMapping("/imgFromNick")
    public String imgFromNick(String nick) {
        System.out.println(nick);
        return memberService.imgFromNick(nick);
    }

    @RequestMapping("/saveProfile")
    public void saveProfile(MemberVo memberVo) {
        memberService.saveProfile(memberVo);
    }

    @RequestMapping("/getProfileImg")
    public void getProfileImg(HttpServletResponse response, HttpServletRequest req, String img) {
        if (img == null) {
            img = "profileDef.png";
        }

        try {
            String path = storage_dir + "profile/img/" + img;

            File file = new File(path);
            response.setHeader("Content-Disposition", "attachment;filename=" + file.getName()); // 다운로드 되거나 로컬에 저장되는 용도로
            response.setHeader("filename", file.getName());
            FileInputStream fileInputStream = new FileInputStream(path); // 파일 읽어오기
            OutputStream out = response.getOutputStream();

            int read = 0;
            byte[] buffer = new byte[1024];
            while ((read = fileInputStream.read(buffer)) != -1) { // 1024바이트씩 계속 읽으면서 outputStream에 저장, -1이 나오면 더이상 읽을
                                                                  // 파일이 없음
                out.write(buffer, 0, read);
            }

            fileInputStream.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/saveImg", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public void saveImg(@RequestParam("saveImg") MultipartFile img, @RequestParam("idx") int idx) {

        String ext = img.getOriginalFilename().substring(img.getOriginalFilename().lastIndexOf(".") + 1);
        String fileName = +idx + "." + ext;
        String path = storage_dir + "profile/img/" + fileName;

        Map map = new HashMap<>();
        map.put("idx", idx);
        map.put("img", fileName);
        memberService.saveProfileImg(map);

        try {
            img.transferTo(new File(path));
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @RequestMapping("/delectImg")
    public void delectImg(int idx) {
        System.out.println(idx + "-11111111111111111111111111111111111111111");
        memberService.delectProfileImg(idx);

    }

    @RequestMapping("selectfollowerlist")
    public List<MemberVo> selectfollowerlist(String nick, int idx) {
        List<MemberVo> selectfollowerlist = followService.selectfollowerlist(nick, idx);
        return selectfollowerlist;
    }

    @RequestMapping("selectfollowinglist")
    public List<MemberVo> selectfollowinglist(String nick, int idx) {
        List<MemberVo> followerlist = followService.selectfollowinglist(nick, idx);
        return followerlist;
    }

    @RequestMapping("deletefollowlist")
    public int deletefollowlist(String nick, int idx) {
        System.out.println(nick);
        System.out.println(idx);
        int deletefollowlist = followService.deletefollowlist(idx, nick);
        return 1;
    }

    @RequestMapping("followinglist")
    public List<RepositoriesVO> followinglist(String nick, int page, String memberIdx) {
        List<RepositoriesVO> list = null;
        int count = 10;
        int start = (page - 1) * count;
        String member = "00";
        Map<String, String> map = new HashMap<String, String>();
        map.put("count", count + "");
        map.put("start", start + "");
        if (memberIdx != null && !memberIdx.equals("")) {
            member = memberIdx;

        }
        map.put("nick", nick);
        map.put("member", member);
        list = followService.followinglist(map);

        return list;
    }

    @RequestMapping("followerlist")
    public List<RepositoriesVO> followerlist(String nick, int page, String memberIdx) {
        List<RepositoriesVO> list = null;
        int count = 10;
        int start = (page - 1) * count;
        String member = "00";
        Map<String, String> map = new HashMap<String, String>();
        map.put("count", count + "");
        map.put("start", start + "");
        if (memberIdx != null && !memberIdx.equals("")) {
            member = memberIdx;

        }
        map.put("nick", nick);
        map.put("member", member);
        list = followService.followerlist(map);

        return list;
    }

    @RequestMapping("followCount")
    public RepositoriesVO followCount(String nick) {

        return followService.followCount(nick);
    }
}
