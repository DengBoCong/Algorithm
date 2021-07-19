package com.dbc.algorithm.Tree;

import com.dbc.algorithm.ReferOffer.PingHengErChaShuLcof;

public class BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean res = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return this.res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0 ;
        int left = dfs(root.left) + 1;
        int right = dfs(root.right) + 1;
        if (Math.abs(left - right) > 1) {
            this.res = false;
        }
        return Math.max(left, right);
    }
}
