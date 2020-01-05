package com.dbc.leecode.Algorithm.Solution41_50;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-01-04 17:20
 **/
public class Solution45 {
    public boolean isMatch(String text, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        //遍历整个字符串
        while (s < text.length()){
            // 一对一匹配，两指针同时后移。
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || text.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // 碰到 *，假设它匹配空串，并且用 startIdx 记录 * 的位置，记录当前字符串的位置，p 后移
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
            // 当前字符不匹配，并且也没有 *，回退
            // p 回到 * 的下一个位置
            // match 更新到下一个位置
            // s 回到更新后的 match
            // 这步代表用 * 匹配了一个字符
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
            //字符不匹配，也没有 *，返回 false
            else return false;
        }

        //将末尾多余的 * 直接匹配空串 例如 text = ab, pattern = a*******
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }
}
