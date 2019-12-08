package com.dbc.leecode.Algorithm.Solution1_10;

public class Solution5 {
    /*
    * 使用中心扩展法
    * */
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

    /*
    * 使用暴力破解法
    * */
    public static String longestPalindromeS2(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                boolean flag = true;
                int len1 = test.length();
                for (int k = 0; k < len1 / 2; k++) {
                    if (test.charAt(k) != test.charAt(len1 - k - 1)) {
                        flag = false;
                    }
                }
                if (flag && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        return ans;
    }

    /*
    * 使用动态规划整体思想
    * */
    public static String longestPalindromeS3(String s) {
        if(s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuilder(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for(int i = 0; i < length; i++)
            for(int j = 0; j < length; j++){
                if(origin.charAt(i) == reverse.charAt(j)){
                    if(i == 0 || j == 0){
                        arr[i][j] = 1;
                    }else{
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                if(arr[i][j] >  maxLen){
                    int beforeRev = length - 1 - j;
                    if(beforeRev + arr[i][j] - 1 == i){ // 用于判断下标是否对应，从而判断是否是回文
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                }
            }
            return s.substring(maxEnd - maxLen + 1, maxLen + 1);
    }

    /*
    * 马拉车算法
    * */
    public static String preProcess(String s){
        int n = s.length();
        if(n == 0){
            return "^$";
        }
        String ret = "^";
        for(int i = 0; i < n; i++){
            ret += "#" + s.charAt(i);
        }
        ret += "#$";
        return ret;
    }


    public static String longestPalindromeS4(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0;
        for(int i = 1; i < n - 1; i++){
            int i_mirror = 2 * C - i;
            if(R > i){
                P[i] = Math.min(R - i, P[i_mirror]); //防止超出R
            }else{
                P[i] = 0 ;//等于R的情况
            }
            //碰到之前讲的三种情况时候，需要利用中心扩展法
            while(T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])){
                P[i]++;
            }

            //判断是否需要更新R
            if(i + P[i] > R){
                C = i;
                R = i + P[i];
            }
        }
        //找出P的最大值
        int maxLen = 0;
        int centerIndex = 0;
        for(int i = 1; i < n - 1; i++){
            if(P[i] > maxLen){
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2;//最开始讲的求原字符串下标
        return s.substring(start, start + maxLen);
    }
}
