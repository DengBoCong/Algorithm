from typing import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def getAllElements(root1: TreeNode, root2: TreeNode) -> List[int]:
    def dfs(node, nums):
        if not node:
            return
        dfs(node.left, nums)
        nums.append(node.val)
        dfs(node.right, nums)

    nums1, nums2, res = [], [], []
    dfs(root1, nums1)
    dfs(root2, nums2)
    len1, len2, left, right = len(nums1), len(nums2), 0, 0
    while left < len1 or right < len2:
        num1 = nums1[left] if left < len1 else 1000000
        num2 = nums2[right] if right < len2 else 1000000
        if num1 <= num2:
            res.append(num1)
            left += 1
        else:
            res.append(num2)
            right += 1

    return res



