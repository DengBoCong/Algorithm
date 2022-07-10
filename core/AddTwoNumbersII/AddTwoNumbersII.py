class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def addTwoNumbers(l1: ListNode, l2: ListNode) -> ListNode:
    stack1, stack2 = [], []
    while l1:
        stack1.append(l1)
        l1 = l1.next
    while l2:
        stack2.append(l2)
        l2 = l2.next
    res, remain = None, 0
    while stack1 or stack2 or remain != 0:
        num1 = stack1.pop().val if stack1 else 0
        num2 = stack2.pop().val if stack2 else 0
        node = ListNode((remain + num1 + num2) % 10)
        remain = (remain + num1 + num2) // 10
        node.next = res
        res = node

    return res



