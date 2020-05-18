package com.dbc.leecode.Algorithm.Solution161_170;

public class Solution163 {
    public int majorityElement(int[] nums){
        int count = 0;
        Integer candidate = null;
        for (int num : nums){
            if (count == 0){
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
