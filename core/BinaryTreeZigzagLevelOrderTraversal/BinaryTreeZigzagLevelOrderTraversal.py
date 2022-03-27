from typing import List
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def zigzagLevelOrder(root: TreeNode) -> List[List[int]]:
    if not root:
        return []

    queue = deque([root])
    res, count = [], 0
    while queue:
        count += 1
        length, temp = len(queue), []
        for _ in range(length):
            node = queue.popleft()
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
            temp.append(node.val)
        if count % 2 == 0:
            temp.reverse()
            res.append(temp)
        else:
            res.append(temp)

    return res
