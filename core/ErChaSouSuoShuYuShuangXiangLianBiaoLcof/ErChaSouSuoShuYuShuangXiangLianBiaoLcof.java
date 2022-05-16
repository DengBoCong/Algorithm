package com.dbc;

import java.util.Stack;

public class ErChaSouSuoShuYuShuangXiangLianBiaoLcof {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        Stack<Node> stack = new Stack<>();
        Node preNode = null, curNode = root, head = null;
        while (!stack.isEmpty() || curNode != null) {
            while (curNode != null) {
                stack.add(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            if (preNode == null) {
                head = curNode;
            } else {
                preNode.right = curNode;
            }
            curNode.left = preNode;
            preNode = curNode;
            curNode = curNode.right;
        }
        if (head != null) {
            head.left = preNode;
            preNode.right = head;
        }

        return head;
    }
}
