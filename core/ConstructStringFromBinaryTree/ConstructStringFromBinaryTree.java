package com.dbc;

public class ConstructStringFromBinaryTree {
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

    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        String res = "" + root.val;
        String left = tree2str(root.left);
        String right = tree2str(root.right);
        if (left.equals("") && right.equals("")) {
            return res;
        } else if (right.equals("")) {
            return res + "(" + left + ")";
        } else {
            return res + "(" + left + ")" + "(" + right + ")";
        }
    }
}
