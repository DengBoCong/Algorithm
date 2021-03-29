class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

def mergeTwoLists(l1: ListNode, l2: ListNode) -> ListNode:
    pre = ListNode(0)
    temp = pre
    while l1 and l2:
        if l1.val <= l2.val:
            temp.next = l1
            temp = temp.next
            l1 = l1.next
        else:
            temp.next = l2
            temp = temp.next
            l2 = l2.next
    
    temp.next = l1 if l1 else l2
    return pre.next
