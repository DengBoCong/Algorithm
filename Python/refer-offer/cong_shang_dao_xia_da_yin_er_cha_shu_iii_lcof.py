from typing import *

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def levelOrder(root: TreeNode) -> List[List[int]]:
    if not root: return []
    res, queue, flag = list(), Deque(), 0
    queue.append(root)
    while queue:
        temp = list()
        for _ in range(len(queue), 0, -1):
            node = queue.popleft()
            if node.left: queue.append(node.left)
            if node.right: queue.append(node.right)
            temp.append(node.val)
        
        if flag % 2 == 1:
            temp.reverse()
        res.append(temp)
        flag += 1
    
    return res