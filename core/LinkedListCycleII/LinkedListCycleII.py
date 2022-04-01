class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def detectCycle(head: ListNode) -> ListNode:
    remain = {}
    while head:
        if remain.get(head, False):
            return head
        remain[head] = True
        head = head.next

    return None

def detectCycle(head: ListNode) -> ListNode:
    slow, fast = head, head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        if slow == fast:
            break

    if not fast or not fast.next:
        return None
    pre_head = head
    while pre_head != slow:
        pre_head = pre_head.next
        slow = slow.next

    return pre_head




