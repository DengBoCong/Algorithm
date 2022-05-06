from typing import List


def subarraySum(nums: List[int], k: int) -> int:
    remain, total, res = {0: 1}, 0, 0
    for num in nums:
        total += num
        res += remain.get(total - k, 0)
        remain[total] = remain.get(total, 0) + 1

    return res




