from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def mergeTwoLists(list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
    prev = ListNode()
    res = prev
    while list1 and list2:
        if list1.val <= list2.val:
            node = list1
            list1 = list1.next
        else:
            node = list2
            list2 = list2.next
        prev.next = node
        prev = prev.next

    node = list1 if list1 else list2
    prev.next = node
    return res.next


