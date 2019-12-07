package com.dbc.leecode.Algorithm.Solution1_10;

public class LongestPalindrome {
    public static String longestPalindromeS1(String s) {
        int max = 1; //记录最大回文字符串的长度
        int max1 = 1; //记录偶数最大回文字符串的长度
        int left = 0;
        int right = 0;
        int left1 = 0;
        int right1 = 0;
        int length = s.length();

        for(int i = 0; i < length; i++){
            int len = 1;
            int leftIndex = i - 1;
            int rightIndex = i + 1;
            while(leftIndex >= 0 && rightIndex < length){
                if(s.charAt(leftIndex) == s.charAt(rightIndex)){
                    len += 2;
                    leftIndex--;
                    rightIndex++;
                }else break;
            }
            if(max < len){
                max = len;
                left = leftIndex + 1;
                right = rightIndex;
            }

            int len1 = 0;
            int leftIndex1 = i;
            int rightIndex1 = i + 1;
            while(leftIndex1 >= 0 && rightIndex1 < length){
                if(s.charAt(leftIndex1) == s.charAt(rightIndex1)){
                    len1 += 2;
                    leftIndex1--;
                    rightIndex1++;
                }else break;
            }
            if(max1 < len1){
                max1 = len1;
                left1 = leftIndex1 + 1;
                right1 = rightIndex1;
            }
        }

        if(max1 < max) return s.substring(left, right);
        else if(s.equals("")) return "";
        else if(max1 == 1 && max == 1) return s.substring(0,1);
        else return s.substring(left1, right1);
    }

    /*public static String longOalindromeS1(int leftIndex, int rightIndex, String s){
        int
    }*/
}
