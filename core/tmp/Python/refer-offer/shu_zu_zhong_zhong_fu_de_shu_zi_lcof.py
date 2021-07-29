from typing import *

def findRepeatNumber(nums: List[int]) -> int:
    remain = dict()
    for num in nums:
        if remain.get(num, -1) != -1:
            return num
        remain[num] = 1
    
    return 0