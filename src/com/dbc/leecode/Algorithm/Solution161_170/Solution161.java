package com.dbc.leecode.Algorithm.Solution161_170;

public class Solution161 {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high){
            int sum = numbers[low] + numbers[high];
            if (sum == target)
                return new int[]{low + 1, high + 1};
            else if (sum < target)
                ++low;
            else
                --high;
        }
        return new int[]{-1, -1};
    }
}
