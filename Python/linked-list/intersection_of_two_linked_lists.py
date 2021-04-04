class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

def getIntersectionNode(headA: ListNode, headB: ListNode) -> ListNode:
    node1, node2 = headA, headB
    while node1 != node2:
        node1 = node1.next if node1 else headB
        node2 = node2.next if node2 else headA
    
    return node1