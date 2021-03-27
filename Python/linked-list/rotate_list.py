class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def rotateRight(head: ListNode, k: int) -> ListNode:
    if head is None:
        return head

    pre = ListNode(0, head)
    front = head

    count = 1
    while front.next:
        count += 1
        front = front.next
    
    count = count - (k % count)
    front.next = head
    for i in range(count):
        head = head.next
        pre = pre.next
    
    pre.next = None
    return head

    
