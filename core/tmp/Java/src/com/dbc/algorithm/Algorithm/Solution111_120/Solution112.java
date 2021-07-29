package com.dbc.leecode.Algorithm.Solution111_120;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-18 10:26
 **/
public class Solution112 {
    public int minDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        if ((root.left == null) && (root.right == null)){
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null){
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null){
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }
}
