package com.dbc;

public class AddTwoNumbers {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int remain = 0;
        ListNode res = new ListNode();
        ListNode point = res;
        while (l1 != null && l2 != null) {
            point.next = new ListNode((l1.val + l2.val + remain) % 10);
            point = point.next;
            remain = (l1.val + l2.val + remain) / 10;

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode node = l1 != null ? l1 : l2;
        while (node != null) {
            point.next = new ListNode((node.val + remain) % 10);
            point = point.next;
            remain = (node.val + remain) / 10;

            node = node.next;
        }

        if (remain != 0) {
            point.next = new ListNode(remain);
        }
        return res.next;
    }
}
