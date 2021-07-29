from typing import *

def removeDuplicates(nums: List[int]) -> int:
    length = len(nums)
    if length <= 2: return length
    slow, fast = 2, 2
    while fast < length:
        if nums[fast] != nums[slow - 2]:
            nums[slow] = nums[fast]
            slow += 1
        fast += 1
    
    return slow