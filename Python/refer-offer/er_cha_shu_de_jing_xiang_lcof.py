class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def mirrorTree(root: TreeNode) -> TreeNode:
    def change(node: TreeNode) -> TreeNode:
        if not node or (not node.left and not node.right):
            return node
        
        temp = node.left
        node.left = change(node.right)
        node.right = change(temp)

        return node
    
    return change(root)