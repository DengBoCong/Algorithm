class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def isBalanced(root: TreeNode) -> bool:
    if not root:
        return False
    res = True
    def dfs(node):
        if not node:
            return 0
        left_deep = dfs(node.left)
        right_deep = dfs(node.right)
        nonlocal res
        if abs(left_deep - right_deep) > 1:
            res = False
        return max(left_deep, right_deep) + 1
    dfs(root)
    return res





