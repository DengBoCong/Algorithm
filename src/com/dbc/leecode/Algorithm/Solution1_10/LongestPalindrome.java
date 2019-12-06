package com.dbc.leecode.Algorithm.Solution1_10;

public class LongestPalindrome {
    public static String longestPalindromeS1(String s) {
        int max = 1; //记录最大回文字符串的长度
        int left = 0;
        int right = 0;
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
        }

        int q = 1;
        int e = 1;
        int z = 0;
        int x = 0;
        for (int i = 0; i < length; i++){
            z = i;
            for (int j = i + 1; j < length; j++){
                if(s.charAt(i) == s.charAt(j)) q++;
                else {
                    if(e < q){
                        e = q;
                        z = i;
                        x = j + 1;
                    }
                    i = j;
                    break;
                }
            }
        }

        if(q < max) return s.substring(left, right);
        else return s.substring(z, x);
    }

    /*public static String longOalindromeS1(int leftIndex, int rightIndex, String s){
        int
    }*/
}
