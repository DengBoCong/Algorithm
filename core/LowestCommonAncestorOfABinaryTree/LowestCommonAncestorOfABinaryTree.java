package com.dbc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestorOfABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private final Map<Integer, TreeNode> parents = new HashMap<>();

    public void dfs(TreeNode root) {
        if (root.left != null) {
            this.parents.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            this.parents.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = this.parents.get(p.val);
        }
        while (q != null) {
            if (set.contains(q)) return q;
            q = this.parents.get(q.val);
        }
        return null;
    }
}
