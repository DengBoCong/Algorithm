class Node:
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next


def insert(head: 'Node', insertVal: int) -> 'Node':
    node = Node(insertVal)
    if head is None:
        node.next = node
        return node
    if head.next == head:
        head.next = node
        node.next = head
        return head

    pre_head, point = head, head.next
    while point != head:
        if pre_head.val <= insertVal <= point.val:
            break
        if pre_head.val > point.val and (insertVal < point.val or insertVal > pre_head.val):
            break
        pre_head = pre_head.next
        point = point.next

    pre_head.next = node
    node.next = point

    return head
