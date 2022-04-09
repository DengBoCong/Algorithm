package com.dbc;

public class RemoveNthNodeFromEndOfList {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode res = preHead;
        while (n > 1) {
            head = head.next;
            n--;
        }
        while (head.next != null) {
            head = head.next;
            preHead = preHead.next;
        }
        preHead.next = preHead.next.next;
        return res.next;
    }
}
