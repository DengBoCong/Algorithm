package com.dbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    private void dfs(boolean[] vis, int[] nums, List<List<Integer>> res, List<Integer> perm, int point) {
        if (point == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) continue;
            perm.add(nums[i]);
            vis[i] = true;
            dfs(vis, nums, res, perm, point + 1);
            vis[i] = false;
            perm.remove(point);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        dfs(vis, nums, res, new ArrayList<>(), 0);
        return res;
    }
}
