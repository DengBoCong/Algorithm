package com.dbc.algorithm.LinkedList;

public class RotateList {
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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode front = head;
        ListNode pre = new ListNode(0, head);
        int count = 1;
        while (front.next != null) {
            count++;
            front = front.next;
        }
        front.next = head;
        count = count - (k % count);
        for (int i = 0; i < count; i++) {
            pre = pre.next;
            head = head.next;
        }

        pre.next = null;
        return head;
    }
}
