package com.dbc.leecode.Algorithm.Solution111_120;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-18 10:34
 **/
public class Solution113 {
    public boolean hasPathSum(TreeNode root, int sum){
        if (root == null){
            return false;
        }

        sum -= root.val;
        if ((root.left == null) && (root.right == null))
            return (sum == 0);
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
