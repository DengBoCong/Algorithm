from typing import List


def minSubArrayLen(target: int, nums: List[int]) -> int:
    left, right, length, total, res = 0, 0, len(nums), 0, 0
    while right < length:
        total += nums[right]
        while total >= target:
            res = right - left + 1 if res == 0 else min(res, right - left + 1)
            total -= nums[left]
            left += 1
        print(left, right)
        right += 1
    return res


if __name__ == '__main__':
    print(minSubArrayLen(11, [1,2,3,4,5]))

