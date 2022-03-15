class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def getIntersectionNode(headA: ListNode, headB: ListNode) -> ListNode:
    if headA is None or headB is None:
        return None
    remainA, remainB = headA, headB
    while headA != headB:
        headA = headB if headA is None else headA
        headB = headA if headB is None else headB

    return headA
