package com.ggit.util;

import java.util.Random;

public class RandStr {
    protected String result = "";

    public RandStr(int size) {
        Random rnd = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 1; i <= size; i++) {
            if (rnd.nextBoolean()) {

                buf.append((char) (rnd.nextInt(26) + 97)); // 0~25(26개) + 65

            } else
                buf.append(rnd.nextInt(10));
        }
        result = buf.toString();
    }

    public String getResult() {
        return result;
    }

}
