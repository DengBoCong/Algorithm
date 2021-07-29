package com.dbc.algorithm.Pointer;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 2) return length;
        int slow = 2, fast = 2;
        while (fast < length) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
