from typing import *

def findContinuousSequence(target: int) -> List[List[int]]:
    total, queue, res = 0, Deque(), list()
    for i in range(1, target + 1):
        if total > target:
            while total > target:
                total -= queue.popleft()
        if total == target:
            res.append(list(queue.copy()))
        
        queue.append(i)
        total += i
    
    return res

if __name__ == "__main__":
    print(findContinuousSequence(9))
