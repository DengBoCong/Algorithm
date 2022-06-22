from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def kthSmallest(root: Optional[TreeNode], k: int) -> int:
    stack, node = [], root
    while stack or node:
        while node:
            stack.append(node)
            node = node.left
        temp = stack.pop()
        k -= 1
        if k == 0:
            return temp.val
        node = temp.right

    return 0



