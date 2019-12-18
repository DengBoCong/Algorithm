package com.dbc.leecode.Algorithm.Solution21_30;

import com.dbc.leecode.Algorithm.Reclass.ListNode;

import java.util.List;

public class Solution24 {
    public static ListNode mergeKListsS1(ListNode[] lists) {
        ListNode listNode = new ListNode(0);
        ListNode result = listNode;

        while (true){
            int min = Integer.MAX_VALUE;
            int flag = -1;
            for (int i = 0; i < lists.length; i++){
                if(lists[i] == null) continue;
                if (min >= lists[i].val){
                    flag = i;
                    min = lists[i].val;
                }
            }
            if(flag == -1) break;
            else {
                listNode.next = lists[flag];
                listNode = listNode.next;
                ListNode listNode1 = lists[flag];
                lists[flag] = lists[flag].next;
                listNode1.next = null;
            }
        }
        return result.next;
    }

    public static ListNode mergeKListsS2(ListNode[] lists) {
        if(lists.length == 0) return null;
        int n = lists.length;
        while (n > 1){
            for (int i = 0; i < n / 2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[n - 1 - i]);
            }

            n = (n + 1) / 2;
        }
        return lists[0];
    }

    public static ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2){
        if(listNode1 == null) return listNode2;
        else if(listNode2 == null) return listNode1;
        else if(listNode1.val < listNode2.val){
            listNode1.next = mergeTwoLists(listNode1.next, listNode2);
            return listNode1;
        }else {
            listNode2.next = mergeTwoLists(listNode1, listNode2.next);
            return listNode2;
        }
    }
}
