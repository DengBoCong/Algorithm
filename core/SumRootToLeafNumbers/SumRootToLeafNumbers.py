class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def sumNumbers(root: TreeNode) -> int:
    res = 0

    def dfs(node, num):
        if not node:
            return
        nonlocal res
        if not node.left and not node.right:
            res += num * 10 + node.val
        dfs(node.left, num * 10 + node.val)
        dfs(node.right, num * 10 + node.val)

    dfs(root, 0)
    return res
