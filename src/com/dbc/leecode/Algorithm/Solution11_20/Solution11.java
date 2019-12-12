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
        //s为字符串，p规则串
        //首先判断，当字符串和匹配串为空时，直接判断匹配成功
        if(p.isEmpty()) return s.isEmpty();

        //上面判断完之后，进一步判断在字符串不为空的前提下，判断字符串的第一个字符是否
        //与规则串的字符相等（注意规则串如果是.也算相等哦），flag为flase不相等，反之相等
        boolean flag = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        //获得了第一个字符是否相等的标记flag之后，我们需要判断规则串此时的下一个字符是不是
        //特殊字符*，如果是，当flag为flase时，说明第一个字符不匹配，我们只要将规则串跳过*就
        // 行；当flag为true时，说明第一个匹配，我们只要将字符串移动下一个，接着进行匹配就行
        if(p.length() >= 2 && p.charAt(1) == '*'){
            //左右两边只要有一个是true就匹配成功
            return isMatchS2(s, p.substring(2)) || flag && isMatchS2(s.substring(1), p);
        }else{
            //如果规则串没有*,且flag为true,直接字符串和规则串同时移动就行
            return flag && isMatchS2(s.substring(1), p.substring(1));
        }
    }

    //动态规划+递归解法
    public static boolean isMatchS3(String s, String p) {
        //这个二维数组用来存对应下标的匹配结果，这样我们在递归中若遇到一样
        // 的直接返回结果就可以了。
        Boolean a[][] = new Boolean[s.length() + 1][p.length() + 1];
        //递归思路和第一种解法差不多，不过我们在递归方法中多传了当前数组的
        // 两个下标（其实就是当前两个字符串匹配到哪了，传入位置）
        return match(a, 0, 0, s, p);
    }

    public static boolean match(Boolean[][] a, int i, int j, String s, String p){
        //首先判断二维数组中的结果
        if(a[i][j] != null) return a[i][j];

        boolean ans;
        //先判断规则串有没有走完，走完了再判断字符串走完了不，同时走完匹配成功，返回true
        if(j == p.length()){
            ans = i == s.length();
        }else{
            //这里是递归的核心思路，和上面的差不多，不过多了是把结果存在二维数组中
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
