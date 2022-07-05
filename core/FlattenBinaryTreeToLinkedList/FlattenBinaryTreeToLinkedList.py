class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def flatten(root: TreeNode) -> None:
    if not root:
        return
    stack, prev = [root], None
    while stack:
        cur = stack.pop()
        if prev:
            prev.right = cur
            prev.left = None
        if cur.right:
            stack.append(cur.right)
        if cur.left:
            stack.append(cur.left)
        prev = cur



