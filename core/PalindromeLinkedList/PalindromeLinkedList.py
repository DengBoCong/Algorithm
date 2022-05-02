class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def isPalindrome(head: ListNode) -> bool:
    count, cur = 0, head
    while cur:
        count += 1
        cur = cur.next
    if count == 1:
        return True

    prev, cur = None, head
    for i in range(count // 2):
        temp = cur.next
        cur.next = prev
        prev = cur
        cur = temp

    if count % 2 == 1:
        cur = cur.next
    while prev and cur:
        if prev.val != cur.val:
            return False
        prev = prev.next
        cur = cur.next

    return True




