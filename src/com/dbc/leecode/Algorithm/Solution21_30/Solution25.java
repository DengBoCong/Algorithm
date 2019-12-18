package com.dbc.leecode.Algorithm.Solution21_30;

import com.dbc.leecode.Algorithm.Reclass.ListNode;

public class Solution25 {
    public static ListNode swapPairsS1(ListNode head) {
        if(head == null) return head;
        if(head.next == null) return head;

        ListNode front = head;
        ListNode back = head.next;
        front.next = back.next;
        back.next = front;
        head = back;

        int count = 0;
        while (true){
            ListNode t = front;
            front = back;
            back = t;
            if(back.next == null || back.next.next == null) break;
            ListNode temp = back;
            back = back.next.next;
            front = front.next.next;

            temp.next.next = back.next;
            temp.next = back;
            back.next = front;
        }

        return head;
    }

    public static ListNode swapPairsS2(ListNode head) {
        if(head == null) return head;
        if(head.next == null) return head;

        ListNode front = head;
        ListNode back = head.next;
        front.next = back.next;
        back.next = front;
        head = back;

        front.next = swapPairsS2(front.next);
        return head;
    }
}
