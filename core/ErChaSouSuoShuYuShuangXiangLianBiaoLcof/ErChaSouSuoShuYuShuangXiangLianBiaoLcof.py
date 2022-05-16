class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def treeToDoublyList(root: 'Node') -> 'Node':
    queue, pre_node, cur_node, head = [], None, root, None
    while queue or cur_node:
        while cur_node:
            queue.append(cur_node)
            cur_node = cur_node.left
        cur_node = queue.pop()
        if pre_node is None:
            head = cur_node
        else:
            pre_node.right = cur_node
        cur_node.left = pre_node
        pre_node = cur_node
        cur_node = cur_node.right

    head.left = pre_node
    pre_node.right = head
    return head




