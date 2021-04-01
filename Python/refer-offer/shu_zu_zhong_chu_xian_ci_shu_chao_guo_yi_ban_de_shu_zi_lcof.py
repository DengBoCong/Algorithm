from typing import *

def majorityElement(nums: List[int]) -> int:
    key, value = nums[0], 1
    for i in range(1, len(nums)):
        if nums[i] == key:
            value += 1
        elif value == 0:
            key, value = nums[i], 1
        else:
            value -= 1
    
    return key