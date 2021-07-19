class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = list()
        while root:
            self.stack.append(root)
            root = root.left


    def next(self) -> int:
        point = self.stack.pop()
        temp = point.right
        while temp:
            self.stack.append(temp)
            temp = temp.left
        
        return point.val

    def hasNext(self) -> bool:
        return len(self.stack) != 0