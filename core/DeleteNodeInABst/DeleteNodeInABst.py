from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def deleteNode(root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
    if root is None:
        return None
    elif root.val > key:
        root.left = deleteNode(root.left, key)
    elif root.val < key:
        root.right = deleteNode(root.right, key)
    elif root.left is None or root.right is None:
        root = root.left if root.left else root.right
    else:
        node = root.right
        while node.left:
            node = node.left
        node.left = root.left
        return root.right
    return root



