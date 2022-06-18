from typing import List
import heapq

def getLeastNumbers(arr: List[int], k: int) -> List[int]:
    if k == 0:
        return []
    res = [-x for x in arr[:k]]
    heapq.heapify(res)
    for i in range(k, len(arr)):
        if -res[0] > arr[i]:
            heapq.heappop(res)
            heapq.heappush(res, -arr[i])

    ans = [-x for x in res]
    return ans


if __name__ == '__main__':
    print(getLeastNumbers([0,0,0,2,0,5], 0))


