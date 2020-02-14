package com.dbc.leecode.Algorithm.Solution91_100;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;

import java.util.Stack;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-14 17:09
 **/
public class Solution99 {
    public boolean isValidBST(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
