package com.dbc.leecode.Algorithm.Solution81_90;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-09 10:16
 **/
public class Solution82 {
    public boolean search(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end){
            mid = start + (end - start) / 2;
            if (nums[mid] == target){
                return true;
            }
            if (nums[start] == nums[mid]){
                start++;
                continue;
            }
            if (nums[start] < nums[mid]){
                if (nums[mid] > target && nums[start] <= target){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else{
                if (nums[mid] < target && nums[end] >= target){
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
