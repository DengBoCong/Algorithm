from typing import List


def maxProduct(nums: List[int]) -> int:
    pre_min, pre_max = nums[0], nums[0]
    length, res = len(nums), nums[0]
    for i in range(1, length):
        pre_max, pre_min = max(max(nums[i] * pre_min, nums[i] * pre_max), nums[i]), min(min(nums[i] * pre_min, nums[i] * pre_max), nums[i])
        res = max(res, pre_max)

    return res




