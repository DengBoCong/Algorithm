package com.dbc.leecode.Algorithm.Solution211_220;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;

public class Solution213 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
