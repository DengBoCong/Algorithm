from typing import *

def findMin(nums: List[int]) -> int:
    length = len(nums)
    left, right = 0, length - 1
    res = 50001
    while left <= right:
        mid = (left + right) // 2
        if nums[mid] <= nums[right]:
            right = mid - 1
        elif nums[mid] >= nums[left]:
            left = mid + 1
        res = min(res, nums[mid])
    
    return res

if __name__ == "__main__":
    print(findMin([11,13,15,17]))