package com.dbc;

public class LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        while (k > 0) {
            head = head.next;
            k--;
        }
        while (head != null) {
            preHead = preHead.next;
            head = head.next;
        }
        return preHead.next;
    }
}
