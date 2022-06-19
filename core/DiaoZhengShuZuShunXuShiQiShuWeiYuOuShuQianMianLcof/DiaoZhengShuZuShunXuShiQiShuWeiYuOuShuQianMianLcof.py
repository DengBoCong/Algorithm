from typing import List


def exchange(nums: List[int]) -> List[int]:
    left, right = 0, len(nums) - 1
    while left < right:
        while left < right and nums[left] % 2 == 1:
            left += 1
        while left < right and nums[right] % 2 == 0:
            right -= 1
        nums[left], nums[right] = nums[right], nums[left]
        left += 1
        right -= 1

    return nums


