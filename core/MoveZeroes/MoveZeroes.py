from typing import List


def moveZeroes(nums: List[int]) -> None:
    point, cur, length = 0, 0, len(nums)
    while cur < length:
        while cur < length and nums[cur] == 0:
            cur += 1
        if cur < length:
            nums[point], nums[cur] = nums[cur], nums[point]
            point += 1
            cur += 1
