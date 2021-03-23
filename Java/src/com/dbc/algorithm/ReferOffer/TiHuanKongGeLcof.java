package com.dbc.algorithm.ReferOffer;

public class TiHuanKongGeLcof {
    public String replaceSpace(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                stringBuffer.append("%20");
            } else {
                stringBuffer.append(ch);
            }
        }
        return stringBuffer.toString();
    }
}
