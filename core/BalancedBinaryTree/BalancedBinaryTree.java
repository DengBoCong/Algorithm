package com.dbc;

public class BalancedBinaryTree {
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

    private boolean res = true;
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int leftDeep = dfs(node.left);
        int rightDeep = dfs(node.right);
        if (Math.abs(leftDeep - rightDeep) > 1) this.res = false;
        return Math.max(leftDeep, rightDeep) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return this.res;
    }
}
