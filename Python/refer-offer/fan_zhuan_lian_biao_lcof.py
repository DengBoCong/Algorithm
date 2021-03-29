class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

def reverseList(head: ListNode) -> ListNode:
    if head is None or head.next is None:
        return head
    
    front, back = head, head.next
    front.next = None

    while back.next:
        temp = back.next
        back.next = front
        front = back
        back = temp
    
    back.next = front
    return back

