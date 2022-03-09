package com.dbc;

public class SmallestRotationWithHighestScore {
    public int bestRotation(int[] nums) {
        int[] diffs = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int low = (i + 1) % nums.length;
            int high = (i - nums[i] + nums.length + 1) % nums.length;
            if (high < low) diffs[0]++;
            diffs[low]++;
            diffs[high]--;
        }

        int res = 0, sum = 0, remain = 0;
        for (int i = 0; i < diffs.length; i++) {
            sum += diffs[i];
            if (sum > remain) {
                res = i;
                remain = sum;
            }
        }
        return res;
    }
}
