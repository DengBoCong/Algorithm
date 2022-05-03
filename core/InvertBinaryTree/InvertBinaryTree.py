class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def invertTree(root: TreeNode) -> TreeNode:
    if not root:
        return root
    left_node = invertTree(root.left)
    right_node = invertTree(root.right)
    root.left = right_node
    root.right = left_node
    return root
