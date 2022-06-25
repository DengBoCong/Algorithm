package com.dbc.code;

public class OddEvenLinkedList {
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

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode remain = head.next;
        ListNode res = head, point = remain;
        while (point != null && point.next != null) {
            res.next = point.next;
            res = res.next;
            point.next = res.next;
            point = point.next;
        }
        res.next = remain;
        return head;
    }
}
