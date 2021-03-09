from typing import List

def nextGreaterElements(nums: List[int]) -> List[int]:
    n = len(nums)
    ret = [-1] * n
    stk = list()

    for i in range(n * 2 - 1):
        while stk and nums[stk[-1]] < nums[i % n]:
            ret[stk.pop()] = nums[i % n]
        stk.append(i % n)
    
    return ret
