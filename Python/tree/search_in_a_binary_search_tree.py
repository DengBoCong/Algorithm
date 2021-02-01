class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def searchBST(root: TreeNode, val: int) -> TreeNode:
    while root is not None:
        if root.val == val:
            break
        elif root.val < val:
            root = root.right
        else:
            root = root.left
    
    return root

if __name__ == "__main__":
    print(searchBST())