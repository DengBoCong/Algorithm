class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

def getKthFromEnd(head: ListNode, k: int) -> ListNode:
    front, back = head, head
    for i in range(k - 1):
        if not back:
            return head
        back = back.next
    
    while back.next:
        front = front.next
        back = back.next
    
    return front