package com.dbc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TwoSumIvInputIsABst {
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

    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{
            add(root);
        }};
        Map<Integer, Boolean> remain = new HashMap<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            if (remain.getOrDefault(k - node.val, false)) return true;
            remain.put(node.val, true);
        }
        return false;
    }
}
