from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def hasPathSum(root: Optional[TreeNode], targetSum: int) -> bool:
    if not root:
        return False
    if not root.left and not root.right and targetSum == root.val:
        return True
    left_res, right_res = False, False
    if root.left:
        left_res = hasPathSum(root.left, targetSum - root.val)
    if root.right:
        right_res = hasPathSum(root.right, targetSum - root.val)

    return left_res or right_res
