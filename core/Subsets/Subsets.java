package com.dbc;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private final List<List<Integer>> res = new ArrayList<List<Integer>>(){{add(new ArrayList<>());}};

    private void dfs(List<Integer> remain, int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            remain.add(nums[i]);
            this.res.add(new ArrayList<>(remain));
            dfs(remain, nums, i + 1);
            remain.remove(remain.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        dfs(new ArrayList<>(), nums, 0);
        return this.res;
    }
}
