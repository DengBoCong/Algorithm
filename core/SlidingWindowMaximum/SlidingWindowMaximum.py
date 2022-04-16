from typing import List
import heapq

def maxSlidingWindow(nums: List[int], k: int) -> List[int]:
    res, queue, remain = [], [], []
    for i in range(k):
        heapq.heappush(queue, (-nums[i], i))

    res.append(-queue[0][0])
    for i in range(k, len(nums)):
        heapq.heappush(queue, (-nums[i], i))
        while queue[0][1] <= i - k:
            heapq.heappop(queue)
        res.append(-queue[0][0])

    return res




