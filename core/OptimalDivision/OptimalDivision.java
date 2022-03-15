package com.dbc;

public class OptimalDivision {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) return "" + nums[0];
        if (nums.length == 2) return nums[0] + "/" + nums[1];
        StringBuffer res = new StringBuffer();
        res.append(nums[0] + "/(");
        for (int i = 1; i < nums.length - 1; i++) {
            res.append(nums[i] + "/");
        }
        res.append(nums[nums.length - 1] + ")");
        return res.toString();
    }
}
