package com.dbc.code;

public class U4eAj6 {
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        if (head == head.next) {
            head.next = node;
            node.next = head;
            return head;
        }
        Node preHead = head, point = head.next;
        while (point != head) {
            if (insertVal >= preHead.val && insertVal <= point.val) break;
            if (preHead.val > point.val && (insertVal > preHead.val || insertVal < point.val)) break;
            preHead = preHead.next;
            point = point.next;
        }
        preHead.next = node;
        node.next = point;
        return head;
    }
}
