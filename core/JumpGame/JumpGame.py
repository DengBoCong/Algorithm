from typing import List


def canJump(nums: List[int]) -> bool:
    left, right = len(nums) - 1, len(nums) - 1
    while left >= 0:
        if nums[left] + left >= right:
            right = left
        left -= 1

    return right == 0


