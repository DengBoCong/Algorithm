package com.dbc.code;

public class FindBottomLeftTreeValue {
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
    private int resDeep = 0;
    private void dfs(TreeNode node, int deep) {
        if (node.left == null && node.right == null && deep > this.resDeep) {
            this.res = node.val;
            this.resDeep = deep;
        }
        if (node.left != null) dfs(node.left, deep + 1);
        if (node.right != null) dfs(node.right, deep + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return this.res;
    }
}
