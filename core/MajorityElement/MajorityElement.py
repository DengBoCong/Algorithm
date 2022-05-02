from typing import List


def majorityElement(nums: List[int]) -> int:
    num, count, length = nums[0], 1, len(nums)

    for i in range(1, length):
        if count == 0:
            num = nums[i]
            count = 1
        elif nums[i] == num:
            count += 1
        else:
            count -= 1

    return num



