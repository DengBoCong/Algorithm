package com.dbc.algorithm.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        List<Integer> d = new ArrayList<>();
        for (int num : nums) {
            if (d.isEmpty() || num > d.get(d.size() - 1)) {
                d.add(num);
            } else {
                int left = 0, right = d.size() - 1;
                int loc = 0;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (d.get(mid) >= num) {
                        loc = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                d.set(loc, num);
            }
        }
        return d.size();
    }
}
