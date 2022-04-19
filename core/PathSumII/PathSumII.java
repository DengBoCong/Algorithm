package com.dbc;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
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

    private final List<List<Integer>> res = new ArrayList<>();
    private void dfs(TreeNode node, List<Integer> nums, int total, int target) {
        total += node.val;
        nums.add(node.val);
        if (node.left == null && node.right == null && total == target) this.res.add(new ArrayList<>(nums));
        if (node.left != null) dfs(node.left, nums, total, target);
        if (node.right != null) dfs(node.right, nums, total, target);
        nums.remove(nums.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root != null) dfs(root, new ArrayList<>(), 0, targetSum);
        return this.res;
    }
}
