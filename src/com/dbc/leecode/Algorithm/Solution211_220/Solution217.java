package com.dbc.leecode.Algorithm.Solution211_220;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;

public class Solution217 {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        dfs(root.left);
        dfs(root.right);
    }
}
