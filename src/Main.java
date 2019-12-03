import Algorithm.Solution1_10;

public class Main {
    public static void main(String[] args) {
        Solution1_10 solution1_10 = new Solution1_10();
        Solution1_10.ListNode firstNode = new Solution1_10.ListNode(2);
        ListNode secondNode = new ListNode(5);
        ListNode l1 = firstNode;
        ListNode l2 = secondNode;
        firstNode.next = new ListNode(4);
        secondNode.next = new ListNode(6);
        firstNode = firstNode.next;
        secondNode = secondNode.next;
        firstNode.next = new ListNode(3);
        secondNode.next = new ListNode(4);
        Solution1_10.Test2S1(l1, l2);
    }
}
