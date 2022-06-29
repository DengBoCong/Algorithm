package com.dbc.code;

public class ErChaShuDeJingXiangLcof {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        TreeNode leftNode = mirrorTree(root.left);
        TreeNode rightNode = mirrorTree(root.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }
}
