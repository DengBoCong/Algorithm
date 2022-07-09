from typing import List


def rotate(nums: List[int], k: int) -> None:
    nums.reverse()
    k = (k - 1) % len(nums)
    left, right = 0, k
    while left < right:
        nums[left], nums[right] = nums[right], nums[left]
        left += 1
        right -= 1
    left, right = k + 1, len(nums) - 1
    while left < right:
        nums[left], nums[right] = nums[right], nums[left]
        left += 1
        right -= 1



