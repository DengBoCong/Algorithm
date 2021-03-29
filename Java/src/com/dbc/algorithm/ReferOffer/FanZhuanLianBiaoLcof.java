package com.dbc.algorithm.ReferOffer;

public class FanZhuanLianBiaoLcof {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode front = head, back = head.next;
        front.next = null;
        while (back.next != null) {
            ListNode temp = back.next;
            back.next = front;
            front = back;
            back = temp;
        }
        back.next = front;
        return back;
    }
}
