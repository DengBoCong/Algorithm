from collections import deque
from operator import le
from typing import List
from sortedcontainers import SortedList

def longestSubarrayTreeMap(nums: List[int], limit: int) -> int:
    left, right, result = 0, 0, 0
    remain = SortedList()
    while right < len(nums):
        remain.add(nums[right])
        if remain[-1] - remain[0] > limit:
            remain.remove(nums[left])
            left += 1
        result = max(result, right - left + 1)
        right += 1
    
    return result

def longestSubarrayQueue(nums: List[int], limit: int) -> int:
    length, left, right, result = len(nums), 0, 0, 0
    imax, imin = deque(), deque()
    while right < length:
        while imax and imax[-1] < nums[right]:
            imax.pop()
        while imin and imin[-1] >nums[right]:
            imin.pop()
        
        imax.append(nums[right])
        imin.append(nums[right])

        if imax[0] - imin[0] > limit:
            if nums[left] == imax[0]:
                imax.popleft()
            if nums[left] == imin[0]:
                imin.popleft()
            left += 1
        result = max(result, right - left + 1)
        right += 1
    return result

if __name__ == "__main__":
    print(longestSubarrayQueue(nums = [4,2,2,2,4,4,2,2], limit = 0))

