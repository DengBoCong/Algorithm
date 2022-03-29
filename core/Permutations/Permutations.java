package com.dbc;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void dfs(int start, int[] nums, List<Integer> remain, List<List<Integer>> res) {
        if (start >= nums.length) {
            res.add(new ArrayList<>(remain));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(start, i, nums);
            remain.add(nums[start]);
            dfs(start + 1, nums, remain, res);
            remain.remove(remain.size() - 1);
            swap(start, i, nums);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> remain = new ArrayList<>();
        dfs(0, nums, remain, res);
        return res;
    }
}
