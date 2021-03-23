package com.dbc.algorithm.ReferOffer;

import java.util.Stack;

public class CongWeiDaoTouDaYinLianBiaoLcof {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int[] result = new int[stack.size()];
        int lenght = stack.size();
        for (int i = 0; i < lenght; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}
