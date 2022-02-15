package com.dbc;

public class SingleElementInASortedArray {
    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if (mid % 2 == 0) {
                if (nums[mid] == nums[mid - 1]) right = mid - 2;
                else left = mid + 2;
            } else {
                if (nums[mid] == nums[mid - 1]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return nums[left];
    }

    public static int singleNonDuplicate1(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 7};
        System.out.println(singleNonDuplicate(nums));
    }
}
