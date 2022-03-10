from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def preorderTraversal(root: Optional[TreeNode]) -> List[int]:
    if root == None:
        return []

    res = [root.val]
    res.extend(preorderTraversal(root.left))
    res.extend(preorderTraversal(root.right))

    return res
