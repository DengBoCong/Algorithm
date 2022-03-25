from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def reverse_list(pre_head, end_node):
    head = pre_head.next
    pre_head.next = end_node
    pre_node = end_node.next
    end_node.next = None
    while head is not None:
        temp_node = head.next
        head.next = pre_node
        pre_node = head
        head = temp_node


def reverseKGroup(head: Optional[ListNode], k: int) -> Optional[ListNode]:
    count = 1
    prev_head = ListNode()
    prev_head.next = head
    left, right = prev_head, head
    while right is not None:
        while right is not None and count < k:
            right = right.next
            count += 1

        if right is not None and count == k:
            temp = left.next
            reverse_list(left, right)
            count = 1
            left = temp
            right = left.next

    return prev_head.next


