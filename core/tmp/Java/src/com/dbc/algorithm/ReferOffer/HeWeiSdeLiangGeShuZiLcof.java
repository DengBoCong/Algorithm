package com.dbc.algorithm.ReferOffer;

public class HeWeiSdeLiangGeShuZiLcof {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        for (int num : nums) {
            if (nums[left] + nums[right] == target) {
                return new int[]{nums[left], nums[right]};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[2];
    }
}
