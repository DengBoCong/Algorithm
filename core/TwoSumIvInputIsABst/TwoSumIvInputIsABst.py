from typing import Optional
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def findTarget(root: Optional[TreeNode], k: int) -> bool:
    remain = {}
    queue = deque([root])
    while queue:
        node = queue.pop()
        if node.left is not None:
            queue.append(node.left)
        if node.right is not None:
            queue.append(node.right)
        if remain.get(k - node.val, False):
            return True
        remain[node.val] = True

    return False
