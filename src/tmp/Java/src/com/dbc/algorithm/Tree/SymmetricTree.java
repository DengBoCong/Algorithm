package com.dbc.algorithm.Tree;

import com.dbc.algorithm.ReferOffer.DuiChengDeErChaShuLcof;

public class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode node1, TreeNode node2) {
        if ((node1 != null && node2 == null) || (node2 != null && node1 == null)) {
            return false;
        } else if (node1 == null) {
            return true;
        }
        return (node1.val == node2.val) && dfs(node1.left, node2.right) && dfs(node1.right, node2.left);
    }
}
