package com.dbc.leecode.Algorithm.Solution111_120;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-18 10:36
 **/
public class Solution114 {
    List<List<Integer>> list = new ArrayList<>();
    ArrayList<Integer> inner = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        if (root == null) return list;
        sum -= root.val;
        inner.add(root.val);
        if (root.left == null && root.right == null){
            if (sum == 0){
                list.add(new ArrayList<>(inner));
            }
        }
        if (root.left != null) pathSum(root.left, sum);
        if (root.right != null) pathSum(root.right, sum);
        inner.remove(inner.size() - 1);
        return list;
    }
}
