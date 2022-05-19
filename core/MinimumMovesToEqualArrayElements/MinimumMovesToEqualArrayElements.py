from typing import List


def minMoves(nums: List[int]) -> int:
    min_num = min(nums)
    return sum([abs(num - min_num) for num in nums])



