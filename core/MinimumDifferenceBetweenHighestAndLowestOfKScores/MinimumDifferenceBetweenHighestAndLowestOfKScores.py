from typing import List
import heapq


def minimumDifference(nums: List[int], k: int) -> int:
    nums.sort()
    right, res = k - 1, 100000
    while right < len(nums):
        res = min(res, nums[right] - nums[right - k + 1])
        right += 1

    return res


if __name__ == '__main__':
    print(minimumDifference([9, 4, 1, 7], 2))
