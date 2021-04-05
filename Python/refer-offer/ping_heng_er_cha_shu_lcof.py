class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        self.res = True
        def dfs(root: TreeNode) -> int:
            if not root:
                return 0
            left = dfs(root.left) + 1
            right = dfs(root.right) + 1
            if abs(left - right) > 1:
                self.res = False
            return max(left, right)
        dfs(root)
        return self.res