from typing import *

def findMin(nums: List[int]) -> int:
    low, high = 0, len(nums) - 1
    while low < high:
        mid = (low + high) // 2
        if nums[mid] < nums[high]:
            high = mid
        elif nums[mid] > nums[high]:
            low = mid + 1
        elif nums[mid] == nums[high]:
            high -= 1
    
    return nums[low]