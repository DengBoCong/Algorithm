package com.dbc;

public class MergeTwoSortedLists {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prev = new ListNode();
        ListNode res = prev;
        while (list1 != null && list2 != null) {
            ListNode node = null;
            if (list1.val <= list2.val) {
                node = list1;
                list1 = list1.next;
            } else {
                node = list2;
                list2 = list2.next;
            }
            prev.next = node;
            prev = prev.next;
        }
        prev.next = list1 != null ? list1 : list2;

        return res.next;
    }
}
