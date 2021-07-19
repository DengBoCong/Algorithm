package com.dbc.algorithm.ReferOffer;

public class LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode front = head, back = head;
        for (int i = 0; i < k - 1; i++) {
            if (back == null) {
                return head;
            }
            back = back.next;
        }
        while (back.next != null) {
            front = front.next;
            back = back.next;
        }
        return front;
    }
}
