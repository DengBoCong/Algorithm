package com.dbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int third = nums.length - 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                while (j < third && nums[j] + nums[third] > target) third--;
                if (j == third) break;
                else if (nums[j] + nums[third] == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[third]);
                    res.add(temp);
                }
            }
        }
        return res;
    }
}
