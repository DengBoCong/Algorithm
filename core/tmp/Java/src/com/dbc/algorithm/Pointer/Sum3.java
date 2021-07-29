package com.dbc.algorithm.Pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < n - 2; first++) {
            if (nums[first] > 0) break;
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = -nums[first];
            int third = n - 1;
            for (int second = first + 1; second < n - 1; second++) {
                if (nums[second] > target) break;
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && (nums[second] + nums[third]) > target) third--;
                if (second == third) break;
                if ((nums[second] + nums[third]) == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
