package com.dbc.algorithm.Tree;

public class SearchInABinarySearchTree {
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

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val)
                break;
            else if (root.val < val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return root;
    }
}
