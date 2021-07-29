from typing import *

def subsetsWithDup(nums: List[int]) -> List[List[int]]:
    res = list()
    ans = list()
    nums = sorted(nums)
    length = len(nums)
    def dfs(choose_pre, point):
        if point == length:
            res.append(ans.copy())
            return
        dfs(False, point + 1)
        if not choose_pre and point != 0 and nums[point] == nums[point - 1]:
            return
        ans.append(nums[point])
        dfs(True, point + 1)
        del ans[-1]
    
    dfs(False, 0)
    return res