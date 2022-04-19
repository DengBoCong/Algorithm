package com.dbc;

import java.util.*;

public class SymmetricTree {
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

    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            int left = 0, right = length - 1;
            while (left < right) {
                if ((queue.get(left) == null && queue.get(right) != null) || (queue.get(left) != null && queue.get(right) == null)) return false;
                if (queue.get(left) != null && queue.get(right) != null && queue.get(left).val != queue.get(right).val) return false;
                left++;
                right--;
            }
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.remove(0);
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        return true;
    }
}
