package com.dbc.algorithm.Daily;

public class SwappingNodesInALinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapNodes(ListNode head, int k) {
        int count = 0;
        ListNode node = head;
        ListNode point = head;

        while (point != null) {
            count++;
            if (count == k) {
                node = point;
            }
            point = point.next;
        }

        point = head;
        for (int i = 0; i < count - k; i++) {
            point = point.next;
        }

        int temp = node.val;
        node.val = point.val;
        point.val = temp;

        return head;
    }
}
