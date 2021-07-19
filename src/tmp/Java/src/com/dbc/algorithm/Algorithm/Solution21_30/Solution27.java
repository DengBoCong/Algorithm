package com.dbc.leecode.Algorithm.Solution21_30;

public class Solution27 {
    public static int removeDuplicatesS1(int[] nums) {
        int length = nums.length;

        if(length == 0) return 0;

        int count = 0;
        int temp = nums[0];

        for (int i = 0; i < length; i++) {

            if(i == 0) continue;

            if(temp != nums[i]){
                count++;
                nums[count] = nums[i];
                temp = nums[i];
            }
        }
        return ++count;
    }
}
