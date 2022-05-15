package com.dbc;

import javafx.util.Pair;

import java.util.*;

public class MaximumWidthOfBinaryTree {
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

    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair<TreeNode, int[]>> queue = new ArrayDeque<>();
        queue.addLast(new Pair<>(root, new int[]{0, 0}));
        int depth = 0, left = 0, res = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, int[]> pair = queue.pollFirst();
            if (pair.getKey() != null) {
                queue.addLast(new Pair<>(pair.getKey().left, new int[]{pair.getValue()[0] * 2, pair.getValue()[1] + 1}));
                queue.addLast(new Pair<>(pair.getKey().right, new int[]{pair.getValue()[0] * 2 + 1, pair.getValue()[1] + 1}));
                if (depth != pair.getValue()[1]) {
                    left = pair.getValue()[0];
                    depth = pair.getValue()[1];
                }
                res = Math.max(res, pair.getValue()[0] - left + 1);
            }
        }
        return res;
    }
}
