package com.dbc.algorithm.ReferOffer;

import java.util.*;

public class CongShangDaoXiaDaYinErChaShuIIILcof {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        int flag = 0;
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                temp.add(node.val);
            }
            if (flag % 2 == 1) {
                Collections.reverse(temp);
            }
            res.add(temp);
            flag++;
        }
        return res;
    }
}
