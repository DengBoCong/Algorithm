package com.dbc;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class CheckCompletenessOfABinaryTree {
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

    public boolean isCompleteTree(TreeNode root) {
        List<Pair<Integer, TreeNode>> queue = new ArrayList<>();
        queue.add(new Pair<>(1, root));
        int index = 0;
        while (index < queue.size()) {
            Pair<Integer, TreeNode> node = queue.get(index);
            if (node.getValue().left != null) queue.add(new Pair<>(node.getKey() * 2, node.getValue().left));
            if (node.getValue().right != null) queue.add(new Pair<>(node.getKey() * 2 + 1, node.getValue().right));
            index++;
        }
        return queue.get(queue.size() - 1).getKey() == queue.size();
    }
}
