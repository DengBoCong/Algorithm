package com.dbc.algorithm.ReferOffer;

import java.util.*;

public class CongShangDaoXiaDaYinErChaShuLcof {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) continue;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            res.add(node.val);
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
