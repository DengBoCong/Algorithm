package com.dbc.leecode.Algorithm.Solution91_100;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-13 11:25
 **/
public class Solution95 {
    public List<Integer> inorderTraversalS1(TreeNode root){
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res){
        if (root != null){
            if (root.left != null){
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null){
                helper(root.right, res);
            }
        }
    }

    public List<Integer> inorderTraversalS2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null){
            if (curr.left == null){
                res.add(curr.val);
                curr = curr.right;
            }else {
                pre = curr.left;
                while (pre.right != null){
                    pre = pre.right;
                }
                pre.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        return res;
    }
}
