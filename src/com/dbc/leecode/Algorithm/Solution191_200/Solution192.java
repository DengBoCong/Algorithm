package com.dbc.leecode.Algorithm.Solution191_200;

import com.dbc.leecode.Algorithm.Reclass.ListNode;

public class Solution192 {
    public ListNode removeElements(ListNode head, int val){
        ListNode prevNode = new ListNode(0);
        prevNode.next = head;
        ListNode frontNode = prevNode;
        ListNode curNode = head;
        while (curNode != null){
            if (curNode.val == val)
                frontNode.next = curNode.next;
            else frontNode = curNode;
            curNode = curNode.next;
        }
        return prevNode.next;
    }
}
