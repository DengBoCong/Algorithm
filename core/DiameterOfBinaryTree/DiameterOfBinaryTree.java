package com.dbc;

public class DiameterOfBinaryTree {
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

    private int res = 0;
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int leftDeep = dfs(node.left);
        int rightDeep = dfs(node.right);
        this.res = Math.max(this.res, leftDeep + rightDeep);
        return Math.max(leftDeep, rightDeep) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return this.res;
    }
}
