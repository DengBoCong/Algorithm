package com.dbc;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] candidates, int total, List<List<Integer>> res, List<Integer> nums, int start) {
        if (start == candidates.length) return;
        if (total == 0) {
            res.add(new ArrayList<>(nums));
            return;
        }
        dfs(candidates, total, res, nums, start + 1);
        if (total - candidates[start] >= 0) {
            nums.add(candidates[start]);
            dfs(candidates, total - candidates[start], res, nums, start);
            nums.remove(nums.size() - 1);
        }
    }
}
