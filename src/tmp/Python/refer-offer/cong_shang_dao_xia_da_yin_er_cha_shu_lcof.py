from typing import *

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def levelOrder(root: TreeNode) -> List[int]:
    queue = Deque()
    queue.append(root)
    res = list()
    while len(queue) != 0:
        node = queue.popleft()
        if not node: continue
        if node.left: queue.append(node.left)
        if node.right: queue.append(node.right)
        res.append(node.val)
    
    return res
