package com.dbc.algorithm.Pointer;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 1) return length;
        int slow = 1, fast = 1;
        while (fast < length) {
            if (nums[fast] != nums[slow - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
