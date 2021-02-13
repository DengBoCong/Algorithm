from typing import List

def quick_find(nums: List[int], left: int, right: int, k: int):
    l = left
    r = right
    mid = nums[left]
    while l < r:
        while l < r and nums[r] >= mid:
            r -= 1
        if l < r:
            nums[l] = nums[r]
            l += 1
        while l < r and nums[l] <= mid:
            l -= 1
        if l < r:
            nums[r] = nums[l]
            r -= 1
    


def findKthLargest(nums: List[int], k: int) -> int:
