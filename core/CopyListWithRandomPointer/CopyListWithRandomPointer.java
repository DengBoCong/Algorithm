package com.dbc;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node preHead = new Node(0);
        Node curNode = preHead, pointNode = head;
        Map<Node, Node> map = new HashMap<>();
        while (pointNode != null) {
            Node node = new Node(pointNode.val);
            curNode.next = node;
            curNode = curNode.next;
            map.put(pointNode, curNode);
            pointNode = pointNode.next;
        }
        for (Map.Entry<Node, Node> item : map.entrySet()) {
            if (item.getKey().random != null) {
                item.getValue().random = map.get(item.getKey().random);
            }
        }
        return preHead.next;
    }
}
