from typing import Optional, List
from copy import deepcopy


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def pathSum(root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
    res = []

    def dfs(node, nums, total):
        total += node.val
        nums.append(node.val)
        if not node.left and not node.right and total == targetSum:
            res.append(deepcopy(nums))
        if node.left:
            dfs(node.left, nums, total)
        if node.right:
            dfs(node.right, nums, total)
        nums.pop()

    if not root:
        return []
    dfs(root, [], 0)
    return res
