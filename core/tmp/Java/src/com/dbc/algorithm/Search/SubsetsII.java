package com.dbc.algorithm.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, nums, 0);
        return res;
    }

    private void dfs(boolean choosePre, int[] nums, int point) {
        if (nums.length == point) {
            res.add(new ArrayList<>(ans));
            return;
        }
        dfs(false, nums, point + 1);
        if (!choosePre && point != 0 && nums[point] == nums[point - 1]) {
            return;
        }
        ans.add(nums[point]);
        dfs(true, nums, point + 1);
        ans.remove(ans.size() - 1);
    }
}
