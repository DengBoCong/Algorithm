package com.dbc.leecode.Algorithm.Solution221_230;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution221 {
    private List<Integer> list;
    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        dfs(root);
        return list.get(k - 1);
    }

    public void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
