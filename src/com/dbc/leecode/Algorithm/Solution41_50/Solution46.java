package com.dbc.leecode.Algorithm.Solution41_50;

public class Solution46 {
    public int jumpS1(int[] nums) {
        int end = 0;
        int maxPostition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPostition = Math.max(maxPostition, nums[i] + i);
            if(i == end){
                end = maxPostition;
                steps++;
            }
        }
        return steps;
    }

    public int jump(int[] nums) {
        int position = nums.length - 1; //要找的位置
        int steps = 0;
        while (position != 0) { //是否到了第 0 个位置
            for (int i = 0; i < position; i++) {
                if (nums[i] >= position - i) {
                    position = i; //更新要找的位置
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
