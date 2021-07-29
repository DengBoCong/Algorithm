package com.dbc.algorithm.Algorithm.Solution1_10;

import com.dbc.leecode.Algorithm.Reclass.ListNode;

/**
 * @program: LeeCode
 * @description:
 * @author: DBC
 * @create: 2019-12-04 11:10
 **/
public class Solution2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     * 测试用例5，5；243,563
     */
    public static ListNode Test2S1(ListNode l1, ListNode l2){
        int ZERO = 0; //用于标志零
        int flag = 0; //标志位，标志所在位数是否进1
        boolean isFirst = true; //标志位，标志是否第一次进入循环
        ListNode sumNode = new ListNode(0);
        ListNode resultNode = sumNode;

        while(l1 != null || l2 != null){
            int sum = 0;
            if(l1 == null) sum = ZERO + l2.val + flag;
            else if(l2 == null) sum = ZERO + l1.val + flag;
            else sum = l1.val + l2.val + flag;

            if(isFirst){
                sumNode.val = sum % 10;
                isFirst = false;
            }else{
                sumNode.next = new ListNode(sum % 10);
                sumNode = sumNode.next;
            }

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            flag = sum / 10;

            if(l1 == null && l2 == null && flag != 0){
                l1 = new ListNode(0);
                l2 = new ListNode(0);
            }
        }
        return resultNode;
    }
}
