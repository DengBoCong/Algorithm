package com.dbc;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycleII {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Boolean> map = new HashMap<>();
        while (head != null) {
            if (map.getOrDefault(head, false)) return head;
            map.put(head, true);
            head = head.next;
        }
        return null;
    }
}
