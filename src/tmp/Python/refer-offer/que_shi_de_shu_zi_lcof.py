from typing import *

def missingNumber(nums: List[int]) -> int:
    left, right = 0, len(nums) - 1
    res = -1
    while left <= right:
        mid = (left + right) // 2
        if nums[mid] != mid:
            res = mid
            right = mid - 1
        else:
            left = mid + 1
    
    return res

if __name__ == "__main__":
    print(missingNumber([0,1,2,3,4,5,6,7,9]))