from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def sumRootToLeaf(root: Optional[TreeNode]) -> int:
    res = 0
    def dfs(stack, node):
        if not node.left and not node.right:
            nonlocal res
            stack.append(str(node.val))
            res += int("".join(stack), 2)
            stack.pop()
            return
        stack.append(str(node.val))
        if node.left:
            dfs(stack, node.left)
        if node.right:
            dfs(stack, node.right)
        stack.pop()

    dfs([], root)
    return res


