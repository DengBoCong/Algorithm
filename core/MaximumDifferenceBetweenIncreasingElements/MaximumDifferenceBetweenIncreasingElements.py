from typing import List


def maximumDifference(nums: List[int]) -> int:
    min_num, div_num = nums[0], -1
    for i in range(1, len(nums)):
        if nums[i] > min_num and nums[i] - min_num > div_num:
            div_num = nums[i] - min_num
        min_num = min_num if min_num < nums[i] else nums[i]

    return div_num
