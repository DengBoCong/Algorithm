from typing import *
import functools

def minNumber(nums: List[int]) -> str:
    def sort_rule(x, y):
        a, b = x + y, y + x
        if a > b: return 1
        elif a < b: return -1
        else: return 0
    nums = [str(num) for num in nums]
    nums = sorted(nums, key=functools.cmp_to_key(sort_rule))
    return "".join(nums)