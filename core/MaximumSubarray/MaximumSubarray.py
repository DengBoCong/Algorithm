from typing import List


def maxSubArray(nums: List[int]) -> int:
    res, prev = nums[0], nums[0]
    for i in range(1, len(nums)):
        prev = max(nums[i], nums[i] + prev)
        res = max(res, prev)

    return res


