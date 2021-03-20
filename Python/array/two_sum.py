from typing import *

def twoSum(nums: List[int], target: int) -> List[int]:
    remain = dict()
    for i, num in enumerate(nums):
        temp = target - num
        if remain.get(temp, "a") != "a":
            return [i, remain.get(temp, "a")]
        else:
            remain[num] = i
    
    return []