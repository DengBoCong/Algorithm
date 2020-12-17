package com.dbc.leecode.Algorithm.Solution101_110;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-15 10:16
 **/
public class Solution104 {
    private List<List<Integer>> levels = new ArrayList<>();
    public void helper(TreeNode node, int level){
        if (levels.size() == level)
            levels.add(new ArrayList<>());
        if ((level & 1) == 1){
            levels.get(level).add(0, node.val);
        }else
            levels.get(level).add(node.val);
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }
}
