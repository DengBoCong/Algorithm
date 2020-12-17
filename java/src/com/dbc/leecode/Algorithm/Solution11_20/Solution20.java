package com.dbc.leecode.Algorithm.Solution11_20;

import com.dbc.leecode.Algorithm.Reclass.ListNode;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2019-12-16 23:36
 **/
public class Solution20 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
