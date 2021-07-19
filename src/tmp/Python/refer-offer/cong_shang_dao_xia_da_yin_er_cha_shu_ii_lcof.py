from typing import *

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def levelOrder(root: TreeNode) -> List[List[int]]:
    if not root: return []
    res, queue = list(), Deque()
    queue.append((root, 0))
    while queue:
        node, layer = queue.popleft()
        if node.left: queue.append((node.left, layer +1))
        if node.right: queue.append((node.right, layer + 1))
        if len(res) == layer:
            res.append(list())
        res[layer].append(node.val)
    
    return res
