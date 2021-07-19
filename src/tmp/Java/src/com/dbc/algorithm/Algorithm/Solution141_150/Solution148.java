package com.dbc.leecode.Algorithm.Solution141_150;

import com.dbc.leecode.Algorithm.Reclass.ListNode;

import java.util.List;

public class Solution148 {
    public ListNode InsertionSortList(ListNode head){
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        for (ListNode node = head; node != null;){
            ListNode cur = node;
            node = node.next;

            if (cur.val < pre.val) pre = dummy;

            while (pre.next != null && cur.val > pre.next.val) pre = pre.next;

            cur.next = pre.next;
            pre.next = cur;
        }

        return dummy.next;
    }
}
