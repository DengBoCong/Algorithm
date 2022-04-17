package com.dbc;

public class SumRootToLeafNumbers {
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

    private long res = 0;

    private void dfs(TreeNode node, long num) {
        if (node == null) return;
        if (node.left == null && node.right == null) this.res += num * 10 + node.val;
        dfs(node.left, num * 10 + node.val);
        dfs(node.right, num * 10 + node.val);
    }

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return (int) this.res;
    }
}
