package com.dbc;

public class ReverseLinkedListII {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode res = preHead;
        int count = 1;
        while (count < left) {
            preHead = preHead.next;
            count++;
        }
        ListNode leftNode = preHead.next;
        ListNode curNode = leftNode, nextNode = leftNode.next;
        while (count < right) {
            ListNode temp = nextNode.next;
            nextNode.next = curNode;
            curNode = nextNode;
            nextNode = temp;
            count++;
        }
        preHead.next = curNode;
        leftNode.next = nextNode;

        return res.next;
    }
}
