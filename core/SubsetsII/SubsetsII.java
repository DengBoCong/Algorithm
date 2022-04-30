package com.dbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    private final List<List<Integer>> res = new ArrayList<>();

    private void dfs(int start, int[] nums, List<Integer> remain, boolean select) {
        if (start == nums.length) {
            this.res.add(new ArrayList<>(remain));
            return;
        }
        dfs(start + 1, nums, remain, false);
        if (!select && start > 0 && nums[start] == nums[start - 1])
            return;
        remain.add(nums[start]);
        dfs(start + 1, nums, remain, true);
        remain.remove(remain.size() - 1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<>(), false);
        return this.res;
    }
}
