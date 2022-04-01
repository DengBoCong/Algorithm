from typing import List, Optional
import heapq


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def mergeKLists(lists: List[Optional[ListNode]]) -> Optional[ListNode]:
    queue, remain, count = [], {}, 0
    for node in lists:
        if node:
            remain[count] = node
            heapq.heappush(queue, (node.val, count))
            count += 1
    pre_head = ListNode()
    res = pre_head
    while queue:
        _, node_count = heapq.heappop(queue)
        pre_head.next = remain[node_count]
        pre_head = pre_head.next
        if remain[node_count].next:
            remain[count] = remain[node_count].next
            heapq.heappush(queue, (remain[node_count].next.val, count))
            count += 1

    return res.next
