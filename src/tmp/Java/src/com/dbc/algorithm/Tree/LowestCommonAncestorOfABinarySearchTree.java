package com.dbc.algorithm.Tree;

import com.dbc.algorithm.ReferOffer.ErChaSouSuoShuDeZuiJinGongGongZuXianLcof;

public class LowestCommonAncestorOfABinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        } else if ((root.val > q.val && root.val < p.val) || (root.val > p.val && root.val < q.val)) {
            return root;
        } else if (root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else
            return lowestCommonAncestor(root.right, p, q);
    }
}
