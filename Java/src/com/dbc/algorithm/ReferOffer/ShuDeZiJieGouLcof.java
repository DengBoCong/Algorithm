package com.dbc.algorithm.ReferOffer;

import java.util.Stack;

public class ShuDeZiJieGouLcof {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
            if ((temp.val == B.val) && recur(temp, B)) {
                return true;
            }
        }
        return false;
    }

    public boolean recur(TreeNode A, TreeNode B) {
        if ((A == null && B == null) || (A != null && B == null)) {
            return true;
        } else if (A != null) {
            return A.val == B.val && recur(A.left, B.left) && recur(A.right, B.right);
        } else {
            return false;
        }
    }
}
