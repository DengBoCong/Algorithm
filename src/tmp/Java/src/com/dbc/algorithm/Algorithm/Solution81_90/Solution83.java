package com.dbc.leecode.Algorithm.Solution81_90;

import com.dbc.leecode.Algorithm.Reclass.ListNode;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-09 11:09
 **/
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        ListNode headHead = new ListNode(-1);
        ListNode pre = headHead;
        headHead.next = head;
        while (head != null && head.next!=null){
            if (head.val != head.next.val){
                pre = head;
                head = head.next;
            }else{
                while (head != null&&head.next != null&&head.val == head.next.val){
                    head = head.next;
                }
                if (head == null){
                    pre.next = null;
                }else{
                    pre.next = head.next;
                    head = head.next;
                }
            }
        }
        return headHead.next;
    }
}
