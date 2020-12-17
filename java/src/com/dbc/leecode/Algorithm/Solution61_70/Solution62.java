package com.dbc.leecode.Algorithm.Solution61_70;

import com.dbc.leecode.Algorithm.Reclass.ListNode;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-02 18:45
 **/
public class Solution62 {
    public ListNode rotateRight(ListNode head, int k){
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode oldTail = head;
        int n;
        for (n = 1; oldTail.next != null; n++)
            oldTail = oldTail.next;
        oldTail.next = head;

        ListNode newTail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            newTail = newTail.next;

        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
