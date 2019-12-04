import com.dbc.leecode.Algorithm.Solution1_10;
import com.dbc.leecode.Reclass.ListNode;

public class Main {
    public static void main(String[] args) {
        Solution1_10 solution1_10 = new Solution1_10();
        ListNode firstNode = new ListNode(0);
        ListNode secondNode = new ListNode(7);
        ListNode l1 = firstNode;
        ListNode l2 = secondNode;
        /*firstNode.next = new ListNode(3);*/
        secondNode.next = new ListNode(3);
        /*firstNode = firstNode.next;
        secondNode = secondNode.next;
        firstNode.next = new ListNode(3);
        secondNode.next = new ListNode(4);*/
        ListNode result = Solution1_10.Test2S1(l1, l2);
    }
}
