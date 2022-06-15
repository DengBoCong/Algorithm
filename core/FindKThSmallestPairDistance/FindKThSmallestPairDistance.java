package com.dbc;

import java.util.Arrays;

public class FindKThSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int i = 0, j = 0; j < nums.length; j++) {
                while (nums[j] - nums[i] > mid) i++;
                count += j - i;
            }
            if (count >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
