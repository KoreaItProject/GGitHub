package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadPushData {
    private String content = "";

    public ReadPushData(String path) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(
                            path), "UTF-8"));
            String str = "";

            while ((str = reader.readLine()) != null) {
                content += str + "\n";
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getCon() {
        return content;
    }

}
