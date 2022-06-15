from typing import List
from bisect import bisect_left


def smallestDistancePair(nums: List[int], k: int) -> int:
    nums.sort()
    left, right = 0, nums[-1] - nums[0]
    while left <= right:
        mid = (left + right) // 2
        point, count = 0, 0
        for index, num in enumerate(nums):
            while num - nums[point] > mid:
                point += 1
            count += index - point
        if count >= k:
            right = mid - 1
        else:
            left = mid + 1

    return left






