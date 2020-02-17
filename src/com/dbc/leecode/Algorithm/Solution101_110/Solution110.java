package com.dbc.leecode.Algorithm.Solution101_110;

import com.dbc.leecode.Algorithm.Reclass.ListNode;
import com.dbc.leecode.Algorithm.Reclass.TreeNode;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-17 10:25
 **/
public class Solution110 {
    private ListNode findMiddleElement(ListNode head){
        ListNode prevPtr = null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null){
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        if (prevPtr != null){
            prevPtr.next = null;
        }
        return slowPtr;
    }

    public TreeNode sortedListToBST(ListNode head){
        if (head == null){
            return null;
        }

        ListNode mid = this.findMiddleElement(head);
        TreeNode node = new TreeNode(mid.val);
        if (head == mid){
            return node;
        }
        node.left = this.sortedListToBST(head);
        node.right = this.sortedListToBST(mid.next);
        return node;
    }
}
