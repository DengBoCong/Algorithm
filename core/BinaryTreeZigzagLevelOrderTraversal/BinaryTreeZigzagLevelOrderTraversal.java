package com.dbc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = false;
        while (!queue.isEmpty()) {
            int length = queue.size();
            flag = !flag;
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = 0; i < length; i ++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (!flag) temp.offerFirst(node.val);
                else temp.offerLast(node.val);
            }
            res.add(new LinkedList<>(temp));
        }
        return res;
    }
}
