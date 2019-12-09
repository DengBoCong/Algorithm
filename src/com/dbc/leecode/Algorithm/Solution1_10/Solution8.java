package com.dbc.leecode.Algorithm.Solution1_10;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2019-12-09 23:38
 **/
public class Solution8 {
    public static int reverseS1(int x) {
        int y = Math.abs(x);
        StringBuffer s = new StringBuffer();
        s.append(y);
        s.reverse();
        y = Integer.parseInt(s.toString());
        if (x < 0) return -y;
        else return y;
    }
}
