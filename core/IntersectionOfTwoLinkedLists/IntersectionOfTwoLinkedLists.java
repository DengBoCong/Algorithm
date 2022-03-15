package com.dbc;

public class IntersectionOfTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode remainA = headA, remainB = headB;
        while (headA != headB) {
            headA = headA == null ? remainB : headA.next;
            headB = headB == null ? remainA : headB.next;
        }
        return headA;
    }
}
