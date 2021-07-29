package com.dbc.algorithm.Math;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
    public static int maximumProductSort(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return Math.max(nums[0] * nums[1] * nums[length - 1], nums[length - 3] * nums[length - 2] * nums[length - 1]);
    }

    public static int maximumProduct(int[] nums) {
        int min1 = 1001, min2 = 1001;
        int max1 = -1001, max2 = -1001, max3 = -1001;
        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
