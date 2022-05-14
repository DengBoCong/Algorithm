class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def swapPairs(head: ListNode) -> ListNode:
    pre_head = ListNode(0)
    pre_head.next = head
    cur_node = pre_head
    while cur_node.next and cur_node.next.next:
        next_node = cur_node.next
        temp_node = cur_node.next.next.next
        cur_node.next = next_node.next
        cur_node.next.next = next_node
        next_node.next = temp_node
        cur_node = next_node

    return pre_head.next


