from typing import List
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def rightSideView(root: TreeNode) -> List[int]:
    if not root:
        return []
    res, queue = [], deque([root])
    while queue:
        length = len(queue)
        level_val = 0
        for _ in range(length):
            node = queue.pop()
            if node.left:
                queue.appendleft(node.left)
            if node.right:
                queue.appendleft(node.right)
            level_val = node.val
        res.append(level_val)

    return res



