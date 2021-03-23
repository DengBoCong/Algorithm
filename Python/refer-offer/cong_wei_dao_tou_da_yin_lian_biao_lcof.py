from typing import *

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

def reversePrint(head: ListNode) -> List[int]:
    stack = list()
    result = []
    while head is not None:
        stack.append(head.val)
        head = head.next
    
    while len(stack) != 0:
        result.append(stack.pop())
    
    return result