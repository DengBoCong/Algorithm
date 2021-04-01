import heapq
from typing import *

def getLeastNumbers(arr: List[int], k: int) -> List[int]:
    if k == 0: return []
    res = [-x for x in arr[:k]]
    heapq.heapify(res)
    for i in range(k, len(arr)):
        if -res[0] > arr[i]:
            heapq.heappop(res)
            heapq.heappush(res, -arr[i])
    
    ans = [-x for x in res]
    return ans

if __name__ == "__main__":
    print(getLeastNumbers(arr = [3,2,1], k = 2))
