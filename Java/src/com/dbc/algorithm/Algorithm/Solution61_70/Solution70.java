package com.dbc.leecode.Algorithm.Solution61_70;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-05 10:53
 **/
public class Solution70 {
    public int mySqrtS1(int x){
        long left = 0;
        long right = Integer.MAX_VALUE;
        while (left < right){
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if(square > x){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return (int)left;
    }

    public int mySqrt(int x){
        long a = x;
        while (a * a > x){
            a = (a + x / a) / 2;
        }
        return (int) a;
    }
}
