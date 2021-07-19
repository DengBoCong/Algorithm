class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

def deleteNode(head: ListNode, val: int) -> ListNode:
    pre = ListNode(0)
    pre.next = head
    while pre.next:
        if pre.next.val == val:
            pre.next = pre.next.next
            continue
        else:
            pre = pre.next
    return pre.next
