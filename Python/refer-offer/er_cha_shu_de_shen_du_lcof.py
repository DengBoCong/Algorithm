class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        self.res = 0
        def dfs(root: TreeNode, depth: int):
            if not root: return
            dfs(root.left, depth + 1)
            self.res = max(self.res, depth)
            dfs(root.right, depth + 1)
        dfs(root, 1)
        return self.res