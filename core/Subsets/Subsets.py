from typing import List
from copy import deepcopy


def subsets(nums: List[int]) -> List[List[int]]:
    res, length = [[]], len(nums)

    def dfs(remain, start):
        for index in range(start, length):
            remain.append(nums[index])
            res.append(deepcopy(remain))
            dfs(remain, index + 1)
            remain.pop()

    dfs([], 0)
    return res
