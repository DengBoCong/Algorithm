import com.dbc.leecode.Algorithm.Reclass.ListNode;
import com.dbc.leecode.Algorithm.Solution11_20.*;
import com.dbc.leecode.Algorithm.Solution1_10.*;
import com.dbc.leecode.Algorithm.Solution21_30.*;
import com.dbc.leecode.Algorithm.Solution31_40.Solution31;
import com.dbc.leecode.Algorithm.Solution31_40.Solution36;
import com.dbc.leecode.Algorithm.Solution31_40.Solution38;
import com.dbc.leecode.Algorithm.Solution31_40.Solution39;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        int s[] = new int[]{1,2,3};
        /*Solution31.nextPermutation(s);
        System.out.println(s.toString());*/
        System.out.println(Solution39.countAndSay(4));
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
    }
}
