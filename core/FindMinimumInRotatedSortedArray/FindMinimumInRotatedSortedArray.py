from typing import List


def findMin(nums: List[int]) -> int:
    left, right, length = 0, len(nums) - 1, len(nums)
    res = 6000
    while left <= right:
        mid = (left + right) // 2
        if nums[mid] >= nums[left]:
            res = min(res, nums[left])
            left = mid + 1
        elif nums[mid] <= nums[right]:
            res = min(res, nums[mid])
            right = mid - 1

    return res


if __name__ == '__main__':
    print(findMin([3, 4, 5, 1, 2]))
    print(findMin([4, 5, 6, 7, 0, 1, 2]))
    print(findMin([11, 13, 15, 17]))
