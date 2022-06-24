from typing import Optional, List
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def largestValues(root: Optional[TreeNode]) -> List[int]:
    if not root:
        return []
    queue = deque([root])
    res = []
    while queue:
        length, layer_max = len(queue), -2 ** 31
        for i in range(length):
            node = queue.popleft()
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
            layer_max = max(layer_max, node.val)
        res.append(layer_max)

    return res


