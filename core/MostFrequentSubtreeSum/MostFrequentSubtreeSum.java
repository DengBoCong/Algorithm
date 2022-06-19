package com.dbc.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private List<Integer> res = new ArrayList<>();

    private int dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int leftNum = dfs(root.left, map);
        int rightNum = dfs(root.right, map);
        int total = leftNum + rightNum + root.val;
        if (res.isEmpty() || map.getOrDefault(total, 0) + 1 == map.get(res.get(0))) res.add(total);
        else if (map.getOrDefault(total, 0) + 1 > map.get(res.get(0))) {
            res = new ArrayList<>();
            res.add(total);
        }
        map.put(total, map.getOrDefault(total, 0) + 1);
        return total;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }
}
