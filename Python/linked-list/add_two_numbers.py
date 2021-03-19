class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def addTwoNumbers(l1: ListNode, l2: ListNode) -> ListNode:
    flag = (l1.val + l2.val) // 10
    result = ListNode(val=(l1.val + l2.val) % 10)
    sign, l1, l2 = result, l1.next, l2.next
    while l1 is not None and l2 is not None:
        temp = ListNode(val=((l1.val + l2.val + flag) % 10))
        flag = (l1.val + l2.val + flag) // 10
        sign.next, l1, l2 = temp, l1.next, l2.next
        sign = sign.next
    
    temp = l1 if l1 is not None else l2
    while temp1 is not None:
        temp = ListNode(val=(temp1.val + flag) % 10)
        flag = (temp1.val + flag) // 10
        sign.next, temp1 = temp, temp1.next
        sign = sign.next
    
    sign.next = ListNode(val=flag) if flag > 0 else None

    return result
