package com.ggit.util;

import java.io.File;
import java.util.zip.ZipException;

import org.zeroturnaround.zip.ZipUtil;

public class PushZip extends Thread {

    private String path;
    private boolean justData;
    // justData = false 를 넣어 토큰 폴더와 data폴더를 모두 압축하는게 원칙이다
    // 하지만 ggitsoure에서 push한 파일은 토큰 압축파일이기 때문에 justData = false를 해서
    // 토큰폴더 압축과정을 생략하고 data만 압축하도록 한다.

    public PushZip(String path) {
        this.path = path;
        this.justData = false;
    }

    public PushZip(String path, boolean justData) {
        this.path = path;
        this.justData = justData;
    }

    @Override
    public void run() {

        if (!justData) {// 토큰 폴더 압축여부
            zip();
        }
        path = path + "\\data";
        zip();

    }

    public void zip() {

        try {
            ZipUtil.pack(new File(path), new File(path + ".zip"));
        } catch (Exception z) {
            try {
                Thread.sleep(300);
                zip();
            } catch (Exception e) {
                zip();
            }

        }

    }
}
