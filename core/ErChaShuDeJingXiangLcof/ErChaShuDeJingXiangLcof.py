class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def mirrorTree(root: TreeNode) -> TreeNode:
    if root is None:
        return root

    left_node = mirrorTree(root.left)
    right_node = mirrorTree(root.right)
    root.left, root.right = right_node, left_node
    return root





