package com.dbc;

public class SortList {
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

    private ListNode mergeSort(ListNode node, int length) {
        if (length <= 1) return node;
        ListNode remain = node;
        for (int i = 1; i < length / 2; i++) remain = remain.next;
        ListNode temp = remain.next;
        remain.next = null;
        ListNode leftNode = mergeSort(node, length / 2);
        ListNode rightNode = mergeSort(temp, length - length / 2);
        ListNode preHead = new ListNode();
        ListNode res = preHead;
        while (leftNode != null && rightNode != null) {
            if (leftNode.val <= rightNode.val) {
                preHead.next = leftNode;
                leftNode = leftNode.next;
            } else {
                preHead.next = rightNode;
                rightNode = rightNode.next;
            }
            preHead = preHead.next;
        }
        preHead.next = leftNode != null ? leftNode : rightNode;
        return res.next;
    }

    public ListNode sortList(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return mergeSort(head, length);
    }
}
