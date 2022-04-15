package com.dbc;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
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

    public TreeNode dfs(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        TreeNode root = new TreeNode(preorder[preLeft]);
        int point = inLeft;
        while (inorder[point] != preorder[preLeft]) point++;
        if (point > inLeft) {
            root.left = dfs(preorder, inorder, preLeft + 1, preLeft + point - inLeft, inLeft, point - 1);
        }
        if (point < inRight) {
            root.right = dfs(preorder, inorder, preLeft + point - inLeft + 1, preRight, point + 1, inRight);
        }
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
}
