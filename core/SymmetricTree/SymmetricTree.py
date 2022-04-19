from typing import Optional
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def isSymmetric(root: Optional[TreeNode]) -> bool:
    queue = deque([root])
    while queue:
        length = len(queue)
        left, right = 0, length - 1
        while left < right:
            if queue[left] and queue[right] and queue[left].val != queue[right].val:
                return False
            if (not queue[left] and queue[right]) or (queue[left] and not queue[right]):
                return False
            left += 1
            right -= 1
        for _ in range(length):
            node = queue.popleft()
            if node:
                queue.append(node.left)
                queue.append(node.right)

    return True
