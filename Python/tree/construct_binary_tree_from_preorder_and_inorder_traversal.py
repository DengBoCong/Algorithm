from typing import *

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def buildTree(preorder: List[int], inorder: List[int]) -> TreeNode:
    def dfs(preorder_left: int, preorder_right: int, inorder_left: int, inorder_right: int) -> TreeNode:
        if preorder_left > preorder_right:
            return None
        
        root = TreeNode(preorder[preorder_left])
        root_index = index[preorder[preorder_left]]
        size_left_subtree = root_index - inorder_left
        
        root.left = dfs(preorder_left + 1, preorder_left + size_left_subtree, inorder_left, root_index - 1)
        root.right = dfs(preorder_left + size_left_subtree + 1, preorder_right, root_index + 1, inorder_right)

        return root
        

    n = len(preorder)
    index = {element: i for i, element in enumerate(inorder)}
    return dfs(0, n - 1, 0, n - 1)

if __name__ == "__main__":
    print(buildTree([3,9,20,15,7], [9,3,15,20,7]))

