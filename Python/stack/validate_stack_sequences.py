from typing import *

def validateStackSequences(pushed: List[int], popped: List[int]) -> bool:
    m, n = len(pushed), len(popped)
    if m != n:
        return False
    if m == 0:
        return True 
    stack = list()
    point1, point2 = 0, 0
    while point2 < n and point1 < m:
        stack.append(pushed[point1])
        point1 += 1
        if stack[-1] == popped[point2]:
            while stack and stack[-1] == popped[point2]:
                stack.pop()
                point2 += 1
    
    return len(stack) == 0

