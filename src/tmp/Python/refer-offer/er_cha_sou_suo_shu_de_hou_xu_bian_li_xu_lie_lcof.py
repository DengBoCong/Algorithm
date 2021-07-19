from typing import *

def verifyPostorder(postorder: List[int]) -> bool:
    def recur(i, j):
        if i >= j: return True
        p = i
        while postorder[p] < postorder[j]: p += 1
        m = p
        while postorder[p] > postorder[j]: p += 1
        return p == j and recur(i, m - 1) and recur(m, j - 1)
    
    return recur(0, len(postorder) - 1)

def verifyPostorder1(postorder: List[int]) -> bool:
    stack, root = [], float("+inf")
    for i in range(len(postorder) - 1, -1, -1):
        if postorder[i] > root: return False
        while stack and postorder[i] < stack[-1]:
            root = stack.pop()
        stack.append(postorder[i])
    
    return True