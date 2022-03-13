package com.dbc;

public class Utf8Validation {
    public boolean validUtf8(int[] data) {
        int count = 0;
        for (int item : data) {
            String uni = "00000000" + Integer.toString(item, 2);
            uni = uni.substring(uni.length() - 8);
            if (count != 0 && !uni.startsWith("10")) {
                return false;
            } else if (count != 0 && uni.startsWith("10")) {
                count--;
            } else if (count == 0 && uni.startsWith("10")) {
                return false;
            } else if (count == 0 && uni.startsWith("11")) {
                count = 1;
                for (int i = 2; i < 8; i++) {
                    if (uni.charAt(i) == '0') {
                        break;
                    }
                    count++;
                }
                if (count > 3) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}
