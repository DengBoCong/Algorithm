class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def addTwoNumbers(l1: ListNode, l2: ListNode) -> ListNode:
    res = ListNode()
    point, remain = res, 0
    while l1 is not None and l2 is not None:
        point.next = ListNode((l1.val + l2.val + remain) % 10)
        point = point.next
        remain = (l1.val + l2.val + remain) // 10

        l1 = l1.next
        l2 = l2.next

    node = l1 if l1 is not None else l2
    while node is not None:
        point.next = ListNode((node.val + remain) % 10)
        point = point.next
        remain = (node.val + remain) // 10

        node = node.next

    if remain != 0:
        point.next = ListNode(remain)

    return res.next

