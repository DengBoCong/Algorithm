from typing import List


def findDisappearedNumbers(nums: List[int]) -> List[int]:
    res, length = [], len(nums)
    for num in nums:
        num = abs(num)
        nums[num - 1] = -abs(nums[num - 1])

    for index in range(length):
        if nums[index] > 0:
            res.append(index + 1)

    return res



