package com.dbc.algorithm.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
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

    public static String dfs(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
        if (root == null)
            return "#";
        String serial = root.val + "," + dfs(root.left, map, result) + "," + dfs(root.right, map, result);
        int count = map.getOrDefault(serial, 0);
        map.put(serial, count + 1);
        if (count == 1)
            result.add(root);
        return serial;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        dfs(root, map, result);
        return result;
    }
}
