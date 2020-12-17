package com.dbc.leecode.Algorithm.Solution121_130;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-23 10:05
 **/
public class Solution126 {
    public boolean isPalindrome(String s){
        int i = 0, j = s.length() - 1;
        while (i < j){
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;j--;
        }
        return true;
    }
}
