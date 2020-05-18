package com.dbc.leecode.Algorithm.Solution121_130;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-24 10:47
 **/
public class Solution130 {
    private int ans = 0;
    private int tmp = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        tmp = tmp * 10 + node.val;
        if (node.left == null && node.right == null) {
            ans += tmp;
        }
        if (node.left != null) {
            dfs(node.left);
        }
        if (node.right != null) {
            dfs(node.right);
        }
        tmp /= 10;
    }
}
