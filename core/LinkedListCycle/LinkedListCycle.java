package com.dbc;

public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        while (head != null) {
            if (head.val > 100000) return true;
            head.val += 200001;
            head = head.next;
        }
        return false;
    }
}
