import com.dbc.leecode.Algorithm.Reclass.ListNode;
import com.dbc.leecode.Algorithm.Solution11_20.*;
import com.dbc.leecode.Algorithm.Solution1_10.*;
import com.dbc.leecode.Algorithm.Solution21_30.*;

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

        int s[] = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(Solution26.reverseKGroup(listNode1, 2));
    }
}
