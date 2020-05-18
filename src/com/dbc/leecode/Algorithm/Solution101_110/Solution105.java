package com.dbc.leecode.Algorithm.Solution101_110;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-15 10:25
 **/
public class Solution105 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }
}
