package com.dbc.algorithm.Array;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            num = (num - 1) % nums.length;
            nums[num] += nums.length;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
