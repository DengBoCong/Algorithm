package com.dbc.leecode.Algorithm.Solution11_20;

import java.util.Arrays;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2019-12-15 19:55
 **/
public class Solution17 {
    public static int threeSumClosestS1(int[] nums, int target) {
        int length = nums.length;
        int result = 10000000;
        Arrays.sort(nums);
        for(int i = 0; i < length; i++){
            if(i == length - 2) break;
            if(i != 0 && nums[i - 1] > target) break;
            int left = i + 1;
            int right = length - 1;
            while (left < right){
                result = Math.abs(result - target) < Math.abs(nums[i] + nums[left] + nums[right] - target)
                        ? result : (nums[i] + nums[left] + nums[right]);
                if ((nums[left] + nums[right]) > (target - nums[i])){
                    right--;
                }else left++;
            }
        }
        return result;
    }

    public static int threeSumClosestS2(int[] nums, int target){
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length - 1;
            while(left != right){
                int min = nums[i] + nums[left] + nums[left + 1];
                if(target < min){
                    if(Math.abs(result - target) > Math.abs(min - target))
                        result = min;
                    break;
                }
                int max = nums[i] + nums[right] + nums[right - 1];
                if(target > max){
                    if(Math.abs(result - target) > Math.abs(max - target))
                        result = max;
                    break;
                }
                int sum = nums[i] + nums[left] + nums[right];
                // 判断三数之和是否等于target
                if(sum == target)
                    return sum;
                if(Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
                if(sum > target){
                    right--;
                    while(left != right && nums[right] == nums[right+1])
                        right--;
                }
                else{
                    left++;
                    while(left != right && nums[left] == nums[left-1])
                        left++;
                }
            }
            while(i<nums.length-2 && nums[i] == nums[i+1])
                i++;
        }
        return result;
    }
}
