from typing import List

def countBits(num: int) -> List[int]:
    remain = [0 for _ in range(num + 1)]
    for i in range(1, num + 1):
        temp = i & (i - 1)
        remain[i] = remain[temp] + 1
    
    return remain