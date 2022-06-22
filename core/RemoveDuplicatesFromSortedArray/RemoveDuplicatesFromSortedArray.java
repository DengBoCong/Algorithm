package com.dbc.code;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int slow = 1, fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
