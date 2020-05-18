package com.dbc.leecode.Algorithm.Solution141_150;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-03-02 10:31
 **/
public class Solution145 {
    public List<Integer> preorderTraversal(TreeNode root){
        LinkedList<Integer> output = new LinkedList<>();

        TreeNode node = root;
        while (node != null){
            if (node.left == null){
                output.add(node.val);
                node = node.right;
            }else {
                TreeNode predecessor = node.left;
                while ((predecessor.right != null) && (predecessor.right != node)){
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null){
                    output.add(node.val);
                    predecessor.right = node;
                    node = node.left;
                }else {
                    predecessor.right = null;
                    node = node.right;
                }
            }
        }
        return output;
    }
}
