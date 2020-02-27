package com.dbc.leecode.Algorithm.Solution131_140;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-27 11:11
 **/
public class Solution137 {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }
}
