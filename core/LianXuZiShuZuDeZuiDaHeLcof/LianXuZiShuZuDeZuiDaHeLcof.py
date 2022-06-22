from typing import List


def maxSubArray(nums: List[int]) -> int:
    res, pre = nums[0], nums[0]
    for i in range(1, len(nums)):
        pre = max(nums[i], pre + nums[i])
        res = max(res, pre)

    return res






