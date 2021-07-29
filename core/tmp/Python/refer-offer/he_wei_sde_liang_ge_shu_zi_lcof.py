from typing import *

def twoSum(nums: List[int], target: int) -> List[int]:
    left, right = 0, len(nums) - 1
    while left < right:
        if nums[left] + nums[right] == target:
            return [nums[left], nums[right]]
        elif nums[left] + nums[right] < target:
            left += 1
        else:
            right -= 1
    
    return []