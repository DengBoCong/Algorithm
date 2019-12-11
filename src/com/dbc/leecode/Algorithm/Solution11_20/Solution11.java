package com.dbc.leecode.Algorithm.Solution11_20;

public class Solution11 {
    public static boolean isMatchS1(String s, String p) {
        int index = 0;

        if(p.length() < 2 && p != ".") return s.equals(p);

        for(int i = 0; i < p.length(); i++){
            int pIndex = i + 1;
            if(p.charAt(pIndex) == '*'){
                for (int j = index; j < s.length(); j++){
                    if(s.charAt(j) != p.charAt(1));
                }
            }else {
                if(s.charAt(index) != p.charAt(i) && p.charAt(i) != '.') return false;
                index++;
            }
        }
        return false;
    }


    //递归解法
    public static boolean isMatchS2(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();

        boolean flag = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if(p.length() >= 2 && p.charAt(1) == '*'){
            return isMatchS2(s, p.substring(2)) || flag && isMatchS2(s.substring(1), p);
        }else{
            return flag && isMatchS2(s.substring(1), p.substring(1));
        }
    }

    //动态规划+递归解法
    public static boolean isMatchS3(String s, String p) {
        Boolean a[][] = new Boolean[s.length() + 1][p.length() + 1];
        return match(a, 0, 0, s, p);
    }

    public static boolean match(Boolean[][] a, int i, int j, String s, String p){
        if(a[i][j] != null) return a[i][j];

        boolean ans;
        if(j == p.length()){
            ans = i == s.length();
        }else{
            boolean flag = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
                ans = match(a, i, j + 2, s, p) || flag && match(a, i + 1, j, s, p);
            }else {
                ans = flag && match(a, i + 1, j + 1, s, p);
            }
        }
        a[i][j] = ans;
        return ans;
    }

    //非递归解法
    public static boolean isMatchS4(String s, String p){
        boolean[][] datas = new boolean[s.length() + 1][p.length() + 1];
        datas[s.length()][p.length()] = true;
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean firstMatch = i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    datas[i][j] = datas[i][j + 2] || firstMatch && datas[i + 1][j];
                } else {
                    datas[i][j] = firstMatch && datas[i + 1][j + 1];
                }
            }
        }
        return datas[0][0];
    }
}
