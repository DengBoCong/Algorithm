package com.dbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    private int flag = 0;
    private final Map<Integer, Integer> counter = new HashMap<>();
    private final Map<String, Integer> tree = new HashMap<>();
    private final List<TreeNode> res = new ArrayList<>();

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

    private String dfs(TreeNode node) {
        if (node == null) {
            return "null";
        }
        String serial = String.format("%s-%s-%s", node.val, dfs(node.left), dfs(node.right));
        int uid = this.tree.computeIfAbsent(serial, key -> flag++);
        this.counter.put(uid, this.counter.getOrDefault(uid, 0) + 1);
        if (this.counter.get(uid) == 2) {
            this.res.add(node);
        }
        return serial;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return this.res;
    }
}
