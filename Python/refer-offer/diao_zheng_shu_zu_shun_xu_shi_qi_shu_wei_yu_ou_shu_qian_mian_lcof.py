from typing import *

def exchange(nums: List[int]) -> List[int]:
    left, right = 0, len(nums) - 1
    while left < right:
        while left < right and nums[left] % 2 == 1:
            left += 1
        while left < right and nums[right] % 2 == 0:
            right -= 1
        
        if left < right:
            temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
        
        left += 1
        right -=1
    
    return nums