from typing import List


def findPeakElement(nums: List[int]) -> int:
    length = len(nums)
    left, right = 0, length - 1
    while left <= right:
        mid = (left + right) // 2
        if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == length - 1 or nums[mid] > nums[mid + 1]):
            return mid
        if (mid == 0 and nums[mid] < nums[mid + 1]) or nums[mid] < nums[mid + 1]:
            left = mid + 1
        else:
            right = mid - 1



