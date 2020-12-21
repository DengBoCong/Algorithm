package com.dbc.leecode.Algorithm.Solution231_240;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution234 {
    private List<String> lists = new ArrayList<>();
    public List<String> binaryTreePathsS1(TreeNode root) {
        if (root == null) return lists;
        if (root.left == null && root.right == null) {
            lists.add("" + root.val);
            return lists;
        }
        if (root.left != null)
            dfs(root.left, "" + root.val);
        if (root.right != null)
            dfs(root.right, "" + root.val);
        return lists;
    }

    public void dfs(TreeNode root, String str) {
        if (root.left == null && root.right == null) {
            lists.add(str + "->" + root.val);
            return;
        }
        if (root.left != null)
            dfs(root.left, str + "->" + root.val);
        if (root.right != null)
            dfs(root.right, str + "->" + root.val);
    }
}
