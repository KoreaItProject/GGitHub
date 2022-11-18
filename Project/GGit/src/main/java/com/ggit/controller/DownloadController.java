package com.ggit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.zeroturnaround.zip.ZipUtil;

import com.ggit.service.BranchService;
import com.ggit.service.FollowService;
import com.ggit.service.MemberService;
import com.ggit.service.PullreqService;
import com.ggit.service.PushService;
import com.ggit.service.RepoService;
import com.ggit.service.RepomemService;
import com.ggit.service.StarService;

import com.ggit.vo.BranchVo;
import com.ggit.vo.FollowVo;
import com.ggit.vo.MemberVo;
import com.ggit.vo.PullreqVo;
import com.ggit.vo.PushVo;
import com.ggit.vo.RepoVo;
import com.ggit.vo.RepomemVo;
import com.ggit.vo.StarVo;

@RestController

@RequestMapping("/download")
public class DownloadController {

    @RequestMapping("")
    public void download(HttpServletResponse response, HttpServletRequest req) {
        try {
            String path = ".\\STORAGE\\File\\gg"; // 경로에 접근할 때 역슬래시('\') 사용

            ZipUtil.pack(new File(path), new File(path += ".zip"));
            System.out.println(req.getRequestURI());
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
            System.out.println((new File(path)).delete());
        } catch (Exception e) {

        }

    }

    @RequestMapping("/123")
    public void download123(HttpServletResponse response, HttpServletRequest req) {
        try {
            String path = ".\\STORAGE\\img\\jin.jpg"; // 경로에 접근할 때 역슬래시('\') 사용

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

}
