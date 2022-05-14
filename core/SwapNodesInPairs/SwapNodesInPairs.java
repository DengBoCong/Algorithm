package com.dbc;

public class SwapNodesInPairs {
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

    public ListNode swapPairs(ListNode head) {
        ListNode preNode = new ListNode();
        preNode.next = head;
        ListNode curNode = preNode;
        while (curNode.next != null && curNode.next.next != null) {
            ListNode nextNode = curNode.next;
            ListNode tempNode = curNode.next.next.next;
            curNode.next = nextNode.next;
            curNode.next.next = nextNode;
            nextNode.next = tempNode;
            curNode = nextNode;
        }
        return preNode.next;
    }
}
