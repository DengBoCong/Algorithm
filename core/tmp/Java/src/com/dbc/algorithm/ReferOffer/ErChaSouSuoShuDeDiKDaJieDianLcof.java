package com.dbc.algorithm.ReferOffer;

public class ErChaSouSuoShuDeDiKDaJieDianLcof {
    private int k;
    private int res;
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (this.k == 0) return;
        this.k--;
        if (this.k == 0) {
            res = root.val;
            return;
        }
        dfs(root.left);
    }
}
