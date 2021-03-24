package com.dbc.algorithm.Tree;

import com.dbc.algorithm.ReferOffer.ZhongJianErChaShuLcof;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int[] preorder;
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, preorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode dfs(int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        TreeNode root = new TreeNode(this.preorder[preorder_left]);
        int root_index = map.get(this.preorder[preorder_left]);
        int size_left_subtree = root_index - inorder_left;
        root.left = dfs(preorder_left + 1, preorder_left + size_left_subtree, inorder_left, root_index - 1);
        root.right = dfs(preorder_left + size_left_subtree + 1, preorder_right, root_index + 1, inorder_right);

        return root;
    }
}
