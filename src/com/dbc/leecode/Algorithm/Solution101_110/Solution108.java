package com.dbc.leecode.Algorithm.Solution101_110;

import com.dbc.leecode.Algorithm.Reclass.TreeNode;

import java.util.*;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-16 16:35
 **/
public class Solution108 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(root);

        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> sub = new ArrayList<>();

            if (!queue1.isEmpty()) {
                while(!queue1.isEmpty()) {
                    TreeNode cur = queue1.poll();
                    sub.add(cur.val);
                    if (cur.left != null) {
                        queue2.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue2.offer(cur.right);
                    }
                }
            } else {
                while(!queue2.isEmpty()) {
                    TreeNode cur = queue2.poll();
                    sub.add(cur.val);
                    if (cur.left != null) {
                        queue1.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue1.offer(cur.right);
                    }
                }
            }
            list.add(sub);
        }
        Collections.reverse(list);
        return list;
    }
}
