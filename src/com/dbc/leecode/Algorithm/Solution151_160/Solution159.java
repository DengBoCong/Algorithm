package com.dbc.leecode.Algorithm.Solution151_160;

public class Solution159 {
    public int compareVersionS1(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < nums1.length || j < nums2.length) {
            //这个技巧经常用到，当一个已经遍历结束的话，我们将其赋值为 0
            String num1 = i < nums1.length ? nums1[i] : "0";
            String num2 = j < nums2.length ? nums2[j] : "0";
            int res = compare(num1, num2);
            if (res == 0) {
                i++;
                j++;
            } else {
                return res;
            }
        }
        return 0;
    }

    private int compareS1(String num1, String num2) {
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        if (n1 > n2) {
            return 1;
        } else if (n1 < n2) {
            return -1;
        } else {
            return 0;
        }
    }

    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < nums1.length || j < nums2.length) {
            String num1 = i < nums1.length ? nums1[i] : "0";
            String num2 = j < nums2.length ? nums2[j] : "0";
            int res = compare(num1, num2);
            if (res == 0) {
                i++;
                j++;
            } else {
                return res;
            }
        }
        return 0;
    }

    private int compare(String num1, String num2) {
        //将高位的 0 去掉
        num1 = removeFrontZero(num1);
        num2 = removeFrontZero(num2);
        //先根据长度进行判断
        if (num1.length() > num2.length()) {
            return 1;
        } else if (num1.length() < num2.length()) {
            return -1;
        } else {
            //长度相等的时候
            for (int i = 0; i < num1.length(); i++) {
                if (num1.charAt(i) - num2.charAt(i) > 0) {
                    return 1;
                } else if (num1.charAt(i) - num2.charAt(i) < 0) {
                    return -1;
                }
            }
            return 0;
        }
    }

    private String removeFrontZero(String num) {
        int start = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
                start++;
            } else {
                break;
            }
        }
        return num.substring(start);
    }
}
