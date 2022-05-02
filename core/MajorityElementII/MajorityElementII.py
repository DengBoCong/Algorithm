from typing import List


def majorityElement(nums: List[int]) -> List[int]:
    num1, num2, count1, count2 = 0, 0, 0, 0
    for i in range(len(nums)):
        if count1 > 0 and num1 == nums[i]:
            count1 += 1
        elif count2 > 0 and num2 == nums[i]:
            count2 += 1
        elif count1 == 0:
            num1 = nums[i]
            count1 = 1
        elif count2 == 0:
            num2 = nums[i]
            count2 = 1
        else:
            count1 -= 1
            count2 -= 1

    vote1, vote2 = 0, 0
    for num in nums:
        if count1 > 0 and num == num1:
            vote1 += 1
        if count2 > 0 and num == num2:
            vote2 += 1

    res = []
    if count1 > 0 and vote1 > len(nums) / 3:
        res.append(num1)
    if count2 > 0 and vote2 > len(nums) / 3:
        res.append(num2)

    return res




