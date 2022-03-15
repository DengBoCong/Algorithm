package com.dbc;

public class CountNumberOfMaximumBitwiseOrSubsets {
    private int res = 0;
    private int maxOr = 0;
    private int[] nums;

    private void dfs(int start, int curOr) {
        int tempOr = curOr;
        for (int i = start; i < this.nums.length; i++) {
            curOr = tempOr | this.nums[i];
            if (curOr > this.maxOr) {
                this.res = 1;
                this.maxOr = curOr;
            } else if (curOr == this.maxOr) {
                this.res++;
            }
            dfs(i + 1, curOr);
        }
    }

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        dfs(0, 0);
        return this.res;
    }
}
