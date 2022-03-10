from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def inorderTraversal(root: Optional[TreeNode]) -> List[int]:
    if root == None:
        return []
    res = []
    res.extend(inorderTraversal(root.left))
    res.append(root.val)
    res.extend(inorderTraversal(root.right))
    return res
