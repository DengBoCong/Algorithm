from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def isCompleteTree(root: TreeNode) -> bool:
    queue = deque([root])
    flag = False
    while queue:
        length = len(queue)
        for _ in range(length):
            node = queue.popleft()
            if node.left:
                if flag:
                    return False
                queue.append(node.left)
            else:
                flag = True
            if node.right:
                if flag:
                    return False
                queue.append(node.right)
            else:
                flag = True

    return True






