package com.dbc.leecode.Algorithm.Solution151_160;

import java.util.Arrays;

public class Solution158 {
    public int maximumGap(int[] nums){
        if (nums.length <= 1){
            return 0;
        }

        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++){
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }

        if (max - min == 0)
            return 0;

        int interval = (int) Math.ceil((double)(max - min) / (n - 1));

        int[] bucketMin = new int[n - 1];
        int[] bucketMax = new int[n - 1];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, -1);

        for (int i = 0; i < nums.length; i++){
            int index = (nums[i] - min) / interval;
            if (nums[i] == min || nums[i] == max){
                continue;
            }

            bucketMin[index] = Math.min(nums[i], bucketMin[index]);
            bucketMax[index] = Math.max(nums[i], bucketMax[index]);
        }

        int maxGap = 0;
        int previousMax = min;
        for (int i = 0; i < n - 1; i++){
            if (bucketMax[i] == -1){
                continue;
            }
            maxGap = Math.max(bucketMin[i] - previousMax, maxGap);
            previousMax = bucketMax[i];
        }
        maxGap = Math.max(max - previousMax, maxGap);
        return maxGap;
    }
}
