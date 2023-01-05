package com.ggit.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadData {
    private String content = "";

    public ReadData(String path) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(path), "UTF-8"));
            String str = "";

            while ((str = reader.readLine()) != null) {
                content += str + "\n";
            }
            reader.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public String getCon() {

        return content;
    }

}
