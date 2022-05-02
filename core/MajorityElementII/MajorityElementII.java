package com.dbc;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = 0, num2 = 0, vote1 = 0, vote2 = 0;
        for (int j : nums) {
            if (vote1 > 0 && num1 == j) vote1++;
            else if (vote2 > 0 && num2 == j) vote2++;
            else if (vote1 == 0) {
                num1 = j;
                vote1++;
            } else if (vote2 == 0) {
                num2 = j;
                vote2++;
            } else {
                vote1--;
                vote2--;
            }
        }

        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && num == num1) count1++;
            if (vote2 > 0 && num == num2) count2++;
        }
        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 3) res.add(num1);
        if (count2 > nums.length / 3) res.add(num2);
        return res;
    }
}
