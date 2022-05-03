from typing import List
from copy import deepcopy


def combinationSum(candidates: List[int], target: int) -> List[List[int]]:
    res, length = [], len(candidates)

    def dfs(start, total, nums):
        if start == length:
            return
        if total == 0:
            res.append(deepcopy(nums))
            return
        dfs(start + 1, total, nums)
        if total - candidates[start] >= 0:
            nums.append(candidates[start])
            dfs(start, total - candidates[start], nums)
            nums.pop()

    dfs(0, target, [])
    return res





