package com.dbc.leecode.Algorithm.Solution101_110;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-15 10:04
 **/
public class Solution103 {
    List<List<Integer>> levels = new ArrayList<>();
    public void helper(TreeNode node, int level){
        if (levels.size() == level)
            levels.add(new ArrayList<>());
        levels.get(level).add(node.val);
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    public List<List<Integer>> levelOrderS1(TreeNode root){
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            levels.add(new ArrayList<>());
            int level_length = queue.size();
            for (int i = 0; i < level_length; i++){
                TreeNode node = queue.remove();
                levels.get(level).add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }
        return levels;
    }
}
