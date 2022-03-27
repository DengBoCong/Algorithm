from typing import Optional

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def hasCycle(head: Optional[ListNode]) -> bool:
    while head:
        if head.val > 100000:
            return True
        head.val += 2000001
        head = head.next

    return False



