package com.dbc.leecode.Algorithm.Solution31_40;

public class Solution36 {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = nums[(left + right) / 2];
            if(mid == target) return (left + right) / 2;
            else if(mid < target){
                if(left == right) return left + 1;
                left = (right + left) / 2 + 1;
            }else{
                if(left == right) return left;
                right = (right + left) / 2 -1;
            }
        }
        if(target < nums[left]) return left;
        else return left + 1;
    }
}
