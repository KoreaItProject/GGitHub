package com.ggit.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WriteData {
    String path;

    public WriteData(String path) {
        this.path = path;

    }

    public void write(String con) {
        try {

            // 3. Buffer를 사용해서 File에 write할 수 있는 BufferedWriter 생성

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));

            // 4. 파일에 쓰기
            writer.write(con);

            // 5. BufferedWriter close
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
