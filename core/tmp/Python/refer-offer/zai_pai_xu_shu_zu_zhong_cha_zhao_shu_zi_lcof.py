from typing import *

def search(nums: List[int], target: int) -> int:
    def helper(tar):
        i, j = 0, len(nums) - 1
        while i <= j:
            m = (i + j) // 2
            if nums[m] <= tar: i = m + 1
            else: j = m - 1
        return i
    return helper(target) - helper(target - 1)