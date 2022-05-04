package com.dbc;

public class RemoveDuplicatesFromSortedList {
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) cur.next = cur.next.next;
            cur = cur.next;
        }
        return head;
    }
}
