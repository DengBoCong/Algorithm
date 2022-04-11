from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
    def merge_sort(node, length):
        if length <= 1:
            return node

        temp = node
        for i in range(0, length // 2 - 1):
            temp = temp.next

        next_node = temp.next
        temp.next = None
        left_node = merge_sort(node, length // 2)
        right_node = merge_sort(next_node, length - (length // 2))
        pre_head = ListNode()
        res = pre_head
        while left_node and right_node:
            if left_node.val <= right_node.val:
                pre_head.next = left_node
                left_node = left_node.next
            else:
                pre_head.next = right_node
                right_node = right_node.next
            pre_head = pre_head.next
        pre_head.next = left_node if left_node else right_node
        return res.next

    list_length = 0
    remain = head
    while head:
        list_length += 1
        head = head.next

    return merge_sort(remain, list_length)
