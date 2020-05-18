package com.dbc.leecode.Algorithm.Solution91_100;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-13 12:10
 **/
public class Solution96 {
    public List<TreeNode> generateTrees(int n){
        List<TreeNode> ans = new ArrayList<>();
        if (n == 0){
            return ans;
        }
        return getAns(1, n);
    }

    private List<TreeNode> getAns(int start, int end){
        List<TreeNode> ans = new ArrayList<>();
        if (start > end){
            ans.add(null);
            return ans;
        }

        if (start == end){
            TreeNode tree = new TreeNode(start);
            ans.add(tree);
            return ans;
        }
        for (int i = start; i <= end; i++){
            List<TreeNode> leftTrees = getAns(start, i - 1);
            List<TreeNode> rightTrees = getAns(i + 1, end);
            for (TreeNode leftTree : leftTrees){
                for (TreeNode rightTree : rightTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
