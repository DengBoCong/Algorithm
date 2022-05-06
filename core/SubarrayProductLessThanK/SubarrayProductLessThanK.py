from typing import List


def numSubarrayProductLessThanK(nums: List[int], k: int) -> int:
    res, left, total = 0, 0, 1
    for index, num in enumerate(nums):
        total *= num
        while left <= index and total >= k:
            total //= nums[left]
            left += 1
        res += index - left + 1

    return res


if __name__ == '__main__':
    print(numSubarrayProductLessThanK(nums=[1, 2, 3], k=100))
