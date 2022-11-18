package com.ggit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ggit.service.MemberService;
import com.ggit.vo.MemberVo;

@RestController
public class MemberController {
    @Autowired
    MemberService memberService;

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

        return memberService.imgFromNick(nick);
    }

    @RequestMapping("/saveProfile")
    public void saveProfile(MemberVo memberVo) {
        memberService.saveProfile(memberVo);
    }

    @RequestMapping("/getProfileImg")
    public void getProfileImg(HttpServletResponse response, HttpServletRequest req, String img) {
        try {
            String path = ".\\STORAGE\\profile\\img\\" + img;

            File file = new File(path);
            response.setHeader("Content-Disposition", "attachment;filename=" + file.getName()); // 다운로드 되거나 로컬에 저장되는 용도로
                                                                                                // 쓰이는지를 알려주는 헤더

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

        }

    }

    @RequestMapping(value = "/saveImg", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public Object saveImg(@RequestParam("saveImg") MultipartFile img) {
        System.out.println(img.getOriginalFilename());
        System.out.println(img);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
