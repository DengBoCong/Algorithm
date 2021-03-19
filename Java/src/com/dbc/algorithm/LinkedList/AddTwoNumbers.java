package com.dbc.algorithm.LinkedList;

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
        int flag = (l1.val + l2.val) / 10;
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        ListNode sign = result;
        l1 = l1.next; l2 = l2.next;
        while (l1 != null && l2 != null) {
            ListNode temp = new ListNode((l1.val + l2.val + flag) % 10);
            flag = (l1.val + l2.val + flag) / 10;
            l1 = l1.next; l2 = l2.next;
            sign.next = temp; sign = sign.next;
        }

        ListNode temp1 = l1 != null ? l1 : l2;
        while (temp1 != null) {
            ListNode temp = new ListNode((temp1.val + flag) % 10);
            flag = (temp1.val + flag) / 10;
            temp1 = temp1.next;
            sign.next = temp; sign = sign.next;
        }

        sign.next = flag == 0 ? null : new ListNode(flag);
        return result;
    }
}
