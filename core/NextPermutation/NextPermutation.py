from typing import List


def nextPermutation(nums: List[int]) -> None:
    length = len(nums)
    left, right = length - 2, length - 1
    while left >= 0 and nums[left] >= nums[left + 1]:
        left -= 1

    if left >= 0:
        while nums[right] <= nums[left]:
            right -= 1
        nums[left], nums[right] = nums[right], nums[left]
    left += 1
    right = length - 1

    while left < right:
        nums[left], nums[right] = nums[right], nums[left]
        left += 1
        right -= 1




