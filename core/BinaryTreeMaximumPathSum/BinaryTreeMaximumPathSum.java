package com.dbc;

public class BinaryTreeMaximumPathSum {
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
    private int res = -2000;
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftNum = 0, rightNum = 0, maxVal = 0;
        if (root.left != null) leftNum = dfs(root.left);
        if (root.right != null) rightNum = dfs(root.right);
        maxVal = Math.max(leftNum + root.val, rightNum + root.val);
        maxVal = Math.max(maxVal, root.val);
        this.res = Math.max(this.res, maxVal);
        this.res = Math.max(this.res, root.val + leftNum + rightNum);
        return maxVal;
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return this.res;
    }
}
