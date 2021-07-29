class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def isSubStructure(A: TreeNode, B: TreeNode) -> bool:
    if not B or not A:
        return False

    def recur(node1: TreeNode, node2: TreeNode) -> bool:
        if not node1 and not node2:
            return True
        elif not node2 and node1:
            return True
        elif node1 and node2 and node1.val == node2.val:
            return recur(node1.left, node2.left) and recur(node1.right, node2.right)
        else:
            return False
    
    stack = list()
    stack.append(A)
    while stack:
        temp = stack.pop()
        if temp.right: stack.append(temp.right)
        if temp.left: stack.append(temp.left)
        if temp.val == B.val and recur(temp, B):
            return True
    
    return False

if __name__ == "__main__":
    print(isSubStructure())
    
    
        
        
