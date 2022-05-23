class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def kthLargest(root: TreeNode, k: int) -> int:
    stack, count, cur = [], 0, root
    while stack or cur:
        while cur:
            stack.append(cur)
            cur = cur.right
        cur = stack.pop()
        count += 1
        if count == k:
            return cur.val
        cur = cur.left

    return -1

