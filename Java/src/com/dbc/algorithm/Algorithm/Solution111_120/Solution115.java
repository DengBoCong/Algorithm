package com.dbc.leecode.Algorithm.Solution111_120;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-19 10:14
 **/
public class Solution115 {
    public void flatten(TreeNode root){
        while(root != null){
            if (root.left == null){
                root = root.right;
            }else {
                TreeNode pre = root.left;
                while (pre.right != null){
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}
