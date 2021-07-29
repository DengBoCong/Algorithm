package com.dbc.leecode.Algorithm.Solution111_120;

import com.dbc.leecode.Algorithm.Reclass.Node;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-19 10:56
 **/
public class Solution117 {
    public Node connect(Node root){
        if (root == null){
            return root;
        }
        Node leftmost = root;
        while (leftmost.left != null){
            Node head = leftmost;
            while (head != null){
                head.left.next = head.right;
                if (head.next != null){
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}
