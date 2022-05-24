class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def isUnivalTree(root: TreeNode) -> bool:
    stack, cur, remain = [], root, -1
    while stack or cur:
        while cur:
            stack.append(cur)
            cur = cur.left
        cur = stack.pop()
        if remain != -1 and remain != cur.val:
            return False
        remain = cur.val
        cur = cur.right
    return True


