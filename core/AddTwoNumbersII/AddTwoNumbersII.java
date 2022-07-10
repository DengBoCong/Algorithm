package com.dbc.code;

import java.util.List;
import java.util.Stack;

public class AddTwoNumbersII {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.add(l2);
            l2 = l2.next;
        }
        ListNode res = null;
        int remain = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || remain != 0) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop().val;
            int num2 = stack2.isEmpty() ? 0 : stack2.pop().val;
            ListNode node = new ListNode((remain + num1 + num2) % 10);
            remain = (remain + num1 + num2) / 10;
            node.next = res;
            res = node;
        }
        return res;
    }
}
