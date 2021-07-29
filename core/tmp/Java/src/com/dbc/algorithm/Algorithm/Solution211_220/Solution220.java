package com.dbc.leecode.Algorithm.Solution211_220;

import java.util.ArrayList;
import java.util.List;

public class Solution220 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int cand1 = nums[0], count1 = 0;
        int cand2 = nums[0], count2 = 0;

        for (int num : nums) {
            if (cand1 == num) {
                count1++;
                continue;
            }
            if (cand2 == num) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                cand1 = num;
                count1++;
                continue;
            }
            if (count2 == 0) {
                cand2 = num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (cand1 == num) count1++;
            else if (cand2 == num) count2++;
        }

        if (count1 > nums.length / 3) res.add(cand1);
        if (count2 > nums.length / 3) res.add(cand2);

        return res;
    }
}
