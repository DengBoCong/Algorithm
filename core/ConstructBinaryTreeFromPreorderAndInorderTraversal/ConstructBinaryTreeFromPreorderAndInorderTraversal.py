from typing import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def buildTree(preorder: List[int], inorder: List[int]) -> TreeNode:
    mid, point, length = preorder[0], 0, len(inorder)
    root = TreeNode(mid)
    while inorder[point] != mid:
        point += 1
    if point > 0:
        root.left = buildTree(preorder[1:point + 1], inorder[:point])
    if point < length - 1:
        root.right = buildTree(preorder[point + 1:], inorder[point + 1:])

    return root


