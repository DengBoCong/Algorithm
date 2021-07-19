package com.dbc.leecode.Algorithm.Solution191_200;

import com.dbc.leecode.Algorithm.Reclass.ListNode;

public class Solution197 {
    public ListNode reverseListS1(ListNode head) {
        if (head == null) return null;
        ListNode curNode = head;
        ListNode frontNode = null;
        while (curNode != null){
            ListNode tmpNode = curNode.next;
            curNode.next = frontNode;
            frontNode = curNode;
            curNode = tmpNode;
        }
        return frontNode;
    }

    public static ListNode reverseList(ListNode head){
        if (head == null) return null;
        ListNode resNode = head;
        while (resNode.next != null){
            resNode = resNode.next;
        }
        reverse(head);
        return resNode;
    }

    public static ListNode reverse(ListNode node){
        if (node.next == null) return node;
        ListNode tmpNode = reverse(node.next);
        tmpNode.next = node;
        return node;
    }
}
