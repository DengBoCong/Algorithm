from typing import List


def removeDuplicates(nums: List[int]) -> int:
    left, right, length = 0, 0, len(nums)
    while right < length:
        while right < length and nums[left] == nums[right]:
            right += 1
        if right < length and right > left + 1:
            nums[left + 1] = nums[right]
        left += 1

    return left
