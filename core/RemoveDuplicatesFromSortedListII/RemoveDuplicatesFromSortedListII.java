package com.dbc;

public class RemoveDuplicatesFromSortedListII {
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
        if (head == null) return head;
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode res = preHead;
        while (head != null) {
            boolean delFlag = false;
            while (head.next != null && head.val == head.next.val) {
                delFlag = true;
                head = head.next;
            }
            if (!delFlag) {
                preHead.next = head;
                preHead = preHead.next;
            }
            head = head.next;
        }
        preHead.next = null;
        return res.next;
    }
}
