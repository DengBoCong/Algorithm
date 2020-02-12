package com.dbc.leecode.Algorithm.Solution91_100;

import com.dbc.leecode.Algorithm.Reclass.ListNode;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-12 15:27
 **/
public class Solution93 {
    private boolean stop;
    private ListNode left;

    public void recurseAndReverse(ListNode right, int m, int n){
        if (n == 1){
            return;
        }

        right = right.next;

        if (m > 1){
            this.left = this.left.next;
        }

        this.recurseAndReverse(right, m - 1, n - 1);

        if (this.left == right || right.next == this.left){
            this.stop = true;
        }

        if (!this.stop){
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;
            this.left = this.left.next;
        }

    }

    public ListNode reverseBetweenS1(ListNode head, int m, int n){
        this.left = head;
        this.stop = false;
        this.recurseAndReverse(head, m, n);
        return head;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        ListNode con = prev, tail = cur;

        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }
}


