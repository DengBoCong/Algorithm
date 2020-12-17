package com.dbc.leecode.Algorithm.Solution211_220;

import java.util.ArrayList;
import java.util.List;

public class Solution219 {
    public List<String> summaryRangesS1(int[] nums) {
        int len = nums.length;
        List<String> res = new ArrayList<>();
        if (len == 0) return res;
        if (len == 1) {res.add(nums[0] + "");return res;}
        int front = nums[0];
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != (nums[i - 1] + 1)) {
                if (cur == (i - 1)) res.add(front + "");
                else res.add(front + "->" + nums[i - 1]);
                front = nums[i];
                cur = i;
                if (i == nums.length - 1) res.add(nums[i] + "");
            } else {
                if (i == nums.length - 1) res.add(front + "->" + nums[i]);
            }

        }
        return res;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
                continue;
            if (i == j)
                summary.add(nums[i] + "");
            else
                summary.add(nums[i] + "->" + nums[j]);
            i = j + 1;
        }
        return summary;
    }
}
