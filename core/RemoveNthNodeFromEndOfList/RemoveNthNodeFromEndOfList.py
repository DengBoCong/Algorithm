class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def removeNthFromEnd(head: ListNode, n: int) -> ListNode:
    pre_node = ListNode()
    pre_node.next = head
    point = head
    res = pre_node
    while n > 1:
        point = point.next
        n -= 1

    while point.next:
        point = point.next
        pre_node = pre_node.next

    pre_node.next = pre_node.next.next

    return res.next


