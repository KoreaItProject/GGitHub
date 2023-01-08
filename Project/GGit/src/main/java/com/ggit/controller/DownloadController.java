package com.ggit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class DownloadController {

    @Value("${storage_dir}")
    String storage_dir;

    @Autowired
    RepoService repoService;

    @RequestMapping("/download")
    public void download(HttpServletResponse response, HttpServletRequest req, int repo, String token,
            String fileName) {
        try {

            String path = storage_dir + "repositorys\\" + repo + "\\" + token + "\\data.zip"; // 경로에 접근할 때 역슬래시('\') 사용

            repoService.repoDown(repo);
            response.setHeader("Content-Disposition", "attachment;filename=" +
                    fileName + ".zip"); // 다운로드 되거나 로컬에 저장되는 용도로
            // 쓰이는지를 알려주는 헤더

            response.setHeader("filename", fileName + ".zip");
            FileInputStream fileInputStream = new FileInputStream(path); // 파일 읽어오기
            OutputStream out = response.getOutputStream();

            int read = 0;
            byte[] buffer = new byte[409600];
            while ((read = fileInputStream.read(buffer)) != -1) {
                // outputStream에 저장, -1이 나오면 더이상 읽을
                // 파일이 없음
                out.write(buffer, 0, read);

            }

            fileInputStream.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
