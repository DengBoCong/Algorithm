class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def getKthFromEnd(head: ListNode, k: int) -> ListNode:
    pre_head = ListNode()
    pre_head.next = head
    while k > 0 and head:
        head = head.next
        k -= 1

    while head:
        head = head.next
        pre_head = pre_head.next

    return pre_head.next




