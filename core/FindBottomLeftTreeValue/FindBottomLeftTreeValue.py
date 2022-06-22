from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def findBottomLeftValue(root: Optional[TreeNode]) -> int:
    res, res_deep = 0, 0
    def dfs(node, deep):
        nonlocal res, res_deep
        if not node.left and not node.right and deep > res_deep:
            res = node.val
            res_deep = deep
        if node.left:
            dfs(node.left, deep + 1)
        if node.right:
            dfs(node.right, deep + 1)

    dfs(root, 0)
    return res




