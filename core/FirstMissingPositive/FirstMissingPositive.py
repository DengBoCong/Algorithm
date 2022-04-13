from typing import List

def firstMissingPositive(nums: List[int]) -> int:
    length = len(nums)
    for i in range(length):
        if nums[i] <= 0:
            nums[i] = length + 1

    for i in range(length):
        num = abs(nums[i])
        if num <= length:
            nums[num - 1] = -abs(nums[num - 1])

    for i in range(length):
        if nums[i] > 0:
            return i + 1

    return length + 1


if __name__ == '__main__':
    print(firstMissingPositive([3,4,-1,1]))

