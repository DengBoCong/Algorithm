package com.dbc.algorithm.ReferOffer;

public class ErChaShuDeShenDuLcof {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int res = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return res;
    }
    public void dfs(TreeNode root, int depth) {
        if (root == null) return;
        dfs(root.left, depth + 1);
        res = Math.max(res, depth);
        dfs(root.right, depth + 1);
    }
}
