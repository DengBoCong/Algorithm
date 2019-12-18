package com.dbc.leecode.Algorithm.Reclass;

/**
 * @program: LeeCode
 * @description: 题目编号2的链表节点类
 * @author: DBC
 * @create: 2019-12-04 10:06
 **/
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x){ this.val = x;}

    @Override
    public String toString() {
        String s = "";
        ListNode listNode = this;
        while (listNode != null){
            s += listNode.val;
            listNode = listNode.next;
        }
        return s;
    }
}
