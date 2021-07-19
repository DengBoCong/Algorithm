from typing import *

def removeDuplicates(nums: List[int]) -> int:
    length = len(nums)
    if length <= 1: return length
    slow, fast = 1, 1
    while fast < length:
        if nums[fast] != nums[slow - 1]:
            nums[slow] = nums[fast]
            slow += 1
        fast += 1
    
    return slow