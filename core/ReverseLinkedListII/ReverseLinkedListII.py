class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def reverseBetween(head: ListNode, left: int, right: int) -> ListNode:
    pre_head = ListNode()
    pre_head.next = head
    res, count = pre_head, 1
    while count < left:
        pre_head = pre_head.next
        count += 1

    left_node = pre_head.next
    cur_node, next_node = left_node, left_node.next
    while count < right:
        temp = next_node.next
        next_node.next = cur_node
        cur_node = next_node
        next_node = temp
        count += 1

    pre_head.next = cur_node
    left_node.next = next_node

    return res.next






