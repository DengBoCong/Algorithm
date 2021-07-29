package com.dbc.algorithm.ReferOffer;

public class ShanChuLianBiaoDeJieDianLcof {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                break;
            } else {
                temp = temp.next;
            }
        }
        return pre.next;
    }
}
