package com.dbc.leecode.Algorithm.Solution111_120;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-17 10:36
 **/
final class TreeInfo{
    public final int height;
    public final boolean balanced;

    public TreeInfo(int height, boolean balanced){
        this.height = height;
        this.balanced = balanced;
    }
}

public class Solution111 {
    private TreeInfo isBalancedTreeHelper(TreeNode root){
        if (root == null){
            return new TreeInfo(-1, true);
        }

        TreeInfo left = isBalancedTreeHelper(root.left);
        if (!left.balanced){
            return new TreeInfo(-1, false);
        }
        TreeInfo right = isBalancedTreeHelper(root.right);
        if (!right.balanced){
            return new TreeInfo(-1, false);
        }
        if (Math.abs(left.height - right.height) < 2){
            return new TreeInfo(Math.max(left.height, right.height) + 1, true);
        }
        return new TreeInfo(-1, false);
    }

    public boolean isBalanced(TreeNode root){
        return isBalancedTreeHelper(root).balanced;
    }
}
