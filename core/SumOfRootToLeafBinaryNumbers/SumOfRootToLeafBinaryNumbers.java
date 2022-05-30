package com.dbc;

import java.util.Stack;

public class SumOfRootToLeafBinaryNumbers {
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

    private int res = 0;
    private void dfs(Stack<String> stack, TreeNode node) {
        if (node.left == null && node.right == null) {
            stack.add("" + node.val);
            this.res += Integer.parseInt(String.join("", stack), 2);
            stack.pop();
            return;
        }
        stack.add("" + node.val);
        if (node.left != null) dfs(stack, node.left);
        if (node.right != null) dfs(stack, node.right);
        stack.pop();
    }

    public int sumRootToLeaf(TreeNode root) {
        dfs(new Stack<>(), root);
        return this.res;
    }
}
