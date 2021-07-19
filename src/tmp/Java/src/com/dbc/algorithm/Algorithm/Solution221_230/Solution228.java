package com.dbc.leecode.Algorithm.Solution221_230;

import com.dbc.leecode.Algorithm.Reclass.ListNode;

public class Solution228 {
    public void deleteNode(ListNode node) {
        if (node.next == null) node = null;
        else {
            ListNode tmp = node.next;
            node.val = node.next.val;
            node.next = node.next.next;
            tmp.next = null;
        }
    }
}
