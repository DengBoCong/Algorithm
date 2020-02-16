package com.dbc.leecode.Algorithm.Solution101_110;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;

import java.util.HashMap;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-16 16:12
 **/
public class Solution106 {
    int pre_idx = 0;
    int[] preroder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<>();

    public TreeNode helper(int in_left, int in_right){
        if (in_left == in_right)
            return null;

        int root_val = preroder[pre_idx];
        TreeNode root = new TreeNode(root_val);

        int index = idx_map.get(root_val);
        pre_idx++;
        root.left = helper(in_left, index);
        root.right = helper(index + 1, in_right);
        return root;
    }

    public TreeNode buildTree(int[] preroder, int[] inorder){
        this.preroder = preroder;
        this.inorder = inorder;

        int idx = 0;
        for (Integer val : inorder)
            idx_map.put(val, idx++);
        return helper(0, inorder.length);
    }
}
