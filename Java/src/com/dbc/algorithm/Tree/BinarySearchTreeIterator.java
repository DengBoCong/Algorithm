package com.dbc.algorithm.Tree;

import java.util.Stack;

public class BinarySearchTreeIterator {
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

    private Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode point = stack.pop();
        TreeNode temp = point.right;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        return point.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
