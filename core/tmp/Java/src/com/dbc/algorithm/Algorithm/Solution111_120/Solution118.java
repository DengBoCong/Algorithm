package com.dbc.leecode.Algorithm.Solution111_120;

import com.dbc.leecode.Algorithm.Reclass.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-20 10:13
 **/
public class Solution118 {
    public Node connectS1(Node root){
        if (root == null){
            return root;
        }
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);

        while (Q.size() > 0){
            int size = Q.size();
            for (int i = 0; i < size; i++){
                Node node = Q.poll();
                if (i < size - 1){
                    node.next = Q.peek();
                }
                if (node.left != null){
                    Q.add(node.left);
                }
                if (node.right != null){
                    Q.add(node.right);
                }
            }
        }
        return root;
    }

    private Node prev, leftmost;
    public void processChild(Node childNode){
        if (childNode != null){
            if (this.prev != null){
                this.prev.next = childNode;
            }else {
                this.leftmost = childNode;
            }
            this.prev = childNode;
        }
    }

    public Node connect(Node root){
        if (root == null){
            return root;
        }
        this.leftmost = root;
        Node curr = leftmost;
        while (this.leftmost != null){
            this.prev = null;
            curr = this.leftmost;
            this.leftmost = null;
            while (curr != null){
                this.processChild(curr.left);
                this.processChild(curr.right);
                curr = curr.next;
            }
        }
        return root;
    }

}
