package com.dbc;

import java.util.List;

public class ReverseNodesInKGroup {
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

    private void reverseList(ListNode preHead, ListNode endNode) {
        ListNode head = preHead.next;
        preHead.next = endNode;
        ListNode preNode = endNode.next;
        endNode.next = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = preNode;
            preNode = head;
            head = temp;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode left = preHead, right = head;
        int count = 1;
        while (right != null) {
            while (right != null && count < k) {
                right = right.next;
                count++;
            }
            if (right != null && count == k) {
                ListNode temp = left.next;
                reverseList(left, right);
                count = 1;
                left = temp;
                right = left.next;
            }
        }
        return preHead.next;
    }
}
