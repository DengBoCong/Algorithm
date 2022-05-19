package com.dbc;

import java.util.Random;

public class MinimumMovesToEqualArrayElementsII {
    private void swap(int index1, int index2, int[] nums) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private int quickSelect(int left, int right, int target, int[] nums) {
        Random random = new Random();
        int index = random.nextInt(right - left + 1) + left;
        int indexNum = nums[index];
        swap(index, right, nums);
        index = left;
        for (int i = left; i < right; i++) {
            if (nums[i] <= indexNum) swap(i, index++, nums);
        }
        swap(index, right, nums);
        if (index == target) return nums[index];
        else if (index > target) return quickSelect(left, index - 1, target, nums);
        else return quickSelect(index + 1, right, target, nums);
    }

    public int minMoves2(int[] nums) {
        int select = quickSelect(0, nums.length - 1, nums.length / 2, nums);
        int res = 0;
        for (int num : nums) res += Math.abs(num - select);
        return res;
    }
}
