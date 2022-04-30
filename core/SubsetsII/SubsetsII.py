from typing import List
from copy import deepcopy


def subsetsWithDup(nums: List[int]) -> List[List[int]]:
    nums, length = sorted(nums), len(nums)
    res = []

    def dfs(start, remain, is_repeat):
        if start == length:
            res.append(deepcopy(remain))
            return

        dfs(start + 1, remain, False)
        if not is_repeat and start > 0 and nums[start] == nums[start - 1]:
            return
        remain.append(nums[start])
        dfs(start + 1, remain, True)
        remain.pop()

    dfs(0, [], True)

    return res
