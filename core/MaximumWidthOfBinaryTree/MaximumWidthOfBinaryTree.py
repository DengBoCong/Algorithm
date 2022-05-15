from typing import Optional
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def widthOfBinaryTree(root: Optional[TreeNode]) -> int:
    res, queue = 0, deque([(root, 0, 0)])
    cur_depth, left = 0, 0
    while queue:
        node, pos, depth = queue.popleft()
        if node:
            queue.append((node.left, pos * 2, depth + 1))
            queue.append((node.right, pos * 2 + 1, depth + 1))
            if cur_depth != depth:
                cur_depth = depth
                left = pos
            res = max(res, pos - left + 1)

    return res



