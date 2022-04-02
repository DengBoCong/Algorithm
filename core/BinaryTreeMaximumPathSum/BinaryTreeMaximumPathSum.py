from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def maxPathSum(root: Optional[TreeNode]) -> int:
    res = -2000
    def dfs(node):
        if not node:
            return 0

        left_val, right_val = 0, 0
        if node.left:
            left_val = dfs(node.left)
        if node.right:
            right_val = dfs(node.right)

        max_val = max(left_val + node.val, right_val + node.val)
        max_val = max(max_val, node.val)
        nonlocal res
        res = max(res, max_val)
        res = max(res, left_val + right_val + node.val)
        return max_val

    dfs(root)
    return res





