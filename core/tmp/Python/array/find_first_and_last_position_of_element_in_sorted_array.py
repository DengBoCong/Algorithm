from typing import List

def binary_search(nums: List[int], target: int, lower: bool) -> int:
    n = len(nums)
    left, right, ans = 0, n - 1, n
    while left <= right:
        index = (left + right) // 2
        mid = nums[index]
        if mid > target or (lower and mid >= target):
            right = index - 1
            ans = index
        else:
            left = index + 1
    
    return ans

def searchRange(nums: List[int], target: int) -> List[int]:
    left = binary_search(nums, target, True)
    right = binary_search(nums, target, False) - 1
    if left <= right and right < len(nums) and nums[left] == target and nums[right] == target:
        return [left, right]
    return[-1, -1]


if __name__ == "__main__":
    print(searchRange(nums = [5,7,7,8,8,10], target = 8))