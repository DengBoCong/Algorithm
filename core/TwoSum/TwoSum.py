from typing import List


def twoSum(nums: List[int], target: int) -> List[int]:
    remain = {}
    for index, num in enumerate(nums):
        if remain.get(target - num, None) is not None:
            return [index, remain[target - num]]

        remain[num] = index
