class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def deleteDuplicates(head: ListNode) -> ListNode:
    if not head:
        return head
    pre_head = ListNode(-200)
    pre_head.next = head
    res = pre_head
    while head:
        del_flag = False
        while head.next and head.val == head.next.val:
            head = head.next
            del_flag = True

        if not del_flag:
            pre_head.next = head
            pre_head = pre_head.next
        head = head.next
    pre_head.next = head

    return res.next



