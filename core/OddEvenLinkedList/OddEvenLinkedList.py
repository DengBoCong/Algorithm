from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def oddEvenList(head: Optional[ListNode]) -> Optional[ListNode]:
    if head is None:
        return head
    remain = head.next
    res, point = head, remain
    while point and point.next:
        res.next = point.next
        res = res.next
        point.next = res.next
        point = point.next
    res.next = remain
    return head





