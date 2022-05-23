package com.dbc;

import java.util.Stack;

public class ErChaSouSuoShuDeDiKdaJieDianLcof {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int count = 0;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            count++;
            if (count == k) return cur.val;
            cur = cur.left;
        }
        return -1;
    }
}
