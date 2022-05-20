from typing import Optional


class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random


def copyRandomList(head: 'Optional[Node]') -> 'Optional[Node]':
    new_head = Node(0)
    point_node, cur_node, node_map = head, new_head, {}
    while point_node:
        node = Node(point_node.val)
        cur_node.next = node
        cur_node = cur_node.next
        node_map[point_node] = cur_node
        point_node = point_node.next

    for old_node, new_node in node_map.items():
        if old_node.random:
            new_node.random = node_map[old_node.random]

    return new_head.next
