class ListNode:
    def __init__(self, val=0, next=None) -> None:
        super().__init__()
        self.val = val
        self.next = next


def swapNodes(head: ListNode, k: int) -> ListNode:
    count = 0
    point = head
    node = None

    while point is not None:
        count += 1
        if count == k:
            node = point
        point = point.next
    point = head
    for i in range(count - k):
        point = point.next

    temp = point.val
    point.val = node.val
    node.val = temp

    return head
