from typing import List


def searchRange(nums: List[int], target: int) -> List[int]:
    res = [-1, -1]

    def binary_search(left, right):
        if left > right:
            return
        mid = (left + right) // 2
        if nums[mid] < target:
            binary_search(mid + 1, right)
        elif nums[mid] > target:
            binary_search(left, mid - 1)
        else:
            res[0] = mid if res[0] == -1 else min(mid, res[0])
            res[1] = mid if res[1] == -1 else max(mid, res[1])
            binary_search(left, mid - 1)
            binary_search(mid + 1, right)

    binary_search(0, len(nums) - 1)
    return res
