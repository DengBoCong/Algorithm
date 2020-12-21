package com.dbc.leecode.Algorithm.Solution191_200;

import com.dbc.leecode.Algorithm.Reclass.ListNode;

//请编写函数，实现通过⼀次遍历找到链表中间节点；如果有两个中间节点，则请返回 第⼆个中间节点（使⽤⾮递归⽅式）；

public class Solution195 {
    public static ListNode findHalf(ListNode root){
        if (root == null) return null;
        ListNode frontNode = root;
        ListNode backNode = root.next;
        while (backNode != null){
            frontNode = frontNode.next;
            backNode = backNode.next;
            if (backNode != null) backNode = backNode.next;
        }
        return frontNode;
    }
}
