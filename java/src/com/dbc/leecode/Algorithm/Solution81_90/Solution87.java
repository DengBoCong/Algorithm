package com.dbc.leecode.Algorithm.Solution81_90;

import com.dbc.leecode.Algorithm.Reclass.ListNode;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-10 16:51
 **/
public class Solution87 {
    public ListNode partition(ListNode head, int x){
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null){
            if (head.val < x){
                before.next = head;
                before = before.next;
            }else {
                after.next = head;
                after = after.next;
            }

            head = head.next;
        }
        after.next = null;
        before.next = after_head.next;
        return before_head.next;
    }
}
