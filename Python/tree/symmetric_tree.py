class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def isSymmetric(root: TreeNode) -> bool:
    def isSym(node1: TreeNode, node2: TreeNode) -> bool:
        if (not node1 and node2) or (not node2 and node1):
            return False
        elif not node1 and not node2:
            return True
        
        
        return (node1.val == node2.val) and isSym(node1.left, node2.right) and isSym(node1.right, node2.left)
    if not root: return True
    return isSym(root.left, root.right)
