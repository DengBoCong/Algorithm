from typing import List

def quick_sort(nums: List[int], left: int, right: int):
    if left >= right:
        return

    l, r = left, right
    mid = nums[left]
    while l < r:
        while l < r and nums[r] >= mid:
            r -= 1
        if l < r:
            nums[l] = nums[r]
            l += 1
        while l < r and nums[l] <= mid:
            l += 1
        if l < r:
            nums[r] = nums[l]
            r -= 1
    nums[l] = mid
    quick_sort(nums, left, l - 1)
    quick_sort(nums, l + 1, right)

def arrayPairSum(nums: List[int]) -> int:
    quick_sort(nums, 0, len(nums) - 1)
    result = 0
    for i in range(0, len(nums), 2):
        result += nums[i]
    
    return result

if __name__ == "__main__":
    print(arrayPairSum([6,2,6,5,1,2]))
        