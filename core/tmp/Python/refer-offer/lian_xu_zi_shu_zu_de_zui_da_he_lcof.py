from typing import *

def maxSubArray(nums: List[int]) -> int:
    if len(nums) == 0:
        return 0
    
    res = nums[0]
    for i in range(1, len(nums)):
        if nums[i] + nums[i - 1] > nums[i]:
            nums[i] = nums[i] + nums[i - 1]
        res = max(nums[i], res)
    
    return res

if __name__ == "__main__":
    print(maxSubArray([1]))
