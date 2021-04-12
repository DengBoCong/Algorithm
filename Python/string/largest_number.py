import functools
from typing import List

def largestNumber(nums: List[int]) -> str:
    def sort_relu(a, b):
        x, y = a + b, b + a
        if x > y: return 1
        elif x < y: return -1
        else: return 0
    
    nums = [str(num) for num in nums]
    nums = sorted(nums, key=functools.cmp_to_key(sort_relu))
    return "".join(nums)
