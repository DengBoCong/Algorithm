package com.dbc.algorithm.Array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            num = (num - 1) % nums.length;
            if (nums[num] > nums.length) {
                result.add(num + 1);
            }
            nums[num] += nums.length;
        }
        return result;
    }
}
