class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def deleteDuplicates(head: ListNode) -> ListNode:
    if not head:
        return head
    
    pre = ListNode(0, head)
    cur = pre
    while cur.next and cur.next.next:
        if cur.next.val ==  cur.next.next.val:
            x = cur.next.val
            while cur.next and cur.next.val == x:
                cur.next = cur.next.next
        else:
            cur = cur.next
    
    return pre.next
    

        
    
    return head
