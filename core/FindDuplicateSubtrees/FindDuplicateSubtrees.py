from typing import Optional, List
from collections import Counter

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def findDuplicateSubtrees(root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
    remain, result = Counter(), []

    def dfs(node):
        if node is None:
            return "null"

        res = f"{node.val}"
        left = dfs(node.left)
        right = dfs(node.right)

        key = f"{res}-{left}-{right}"
        if remain[key] == 1:
            result.append(node)

        remain[key] += 1
        return key

    dfs(root)
    return result


