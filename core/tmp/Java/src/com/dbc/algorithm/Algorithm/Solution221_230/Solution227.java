package com.dbc.leecode.Algorithm.Solution221_230;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;

import java.util.*;

public class Solution227 {
    private TreeNode res;
    public boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) return false;

        int left = recurseTree(currentNode.left, p, q) ? 1 : 0;
        int right = recurseTree(currentNode.right, p, q) ? 1 : 0;

        int mid = 0;
        if (currentNode.val == p.val || currentNode.val == q.val) mid = 1;

        if (left + right + mid >= 2) {
            res = currentNode;
            return false;
        } else if (left + right + mid > 0) {
            return true;
        } else return false;
    }

    public TreeNode lowestCommonAncestorS1(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return res;
    }
}
