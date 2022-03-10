from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def postorderTraversal(root: Optional[TreeNode]) -> List[int]:
    if root == None:
        return []
    res = []
    res.extend(postorderTraversal(root.left))
    res.extend(postorderTraversal(root.right))
    res.append(root.val)
    return res
