class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def reverseList(head: ListNode) -> ListNode:
    cur, prev = head, None
    while cur is not None:
        temp = cur.next
        cur.next = prev
        prev = cur
        cur = temp

    return prev


