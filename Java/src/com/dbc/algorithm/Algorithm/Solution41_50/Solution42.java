package com.dbc.leecode.Algorithm.Solution41_50;

public class Solution42 {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int contains = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1){
                contains++;
                break;
            }
        }

        if(contains == 0) return 1;

        if(n == 1) return 2;

        for (int i = 0; i < n; i++) {
            if((nums[i] <= 0) || (nums[i] > n))
                nums[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            // 如果发现了一个数字 a - 改变第 a 个元素的符号
            // 注意重复元素只需操作一次
            if (a == n)
                nums[0] = - Math.abs(nums[0]);
            else
                nums[a] = - Math.abs(nums[a]);
        }

        // 现在第一个正数的下标
        // 就是第一个缺失的数
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0)
                return i;
        }

        if (nums[0] > 0)
            return n;

        return n + 1;
    }
}
