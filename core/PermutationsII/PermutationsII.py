from typing import List
from copy import deepcopy


def permuteUnique(nums: List[int]) -> List[List[int]]:
    res, length = [], len(nums)
    vis = [False] * length

    def dfs(point, remain):
        if point == length:
            res.append(deepcopy(remain))
            return
        for index in range(length):
            if vis[index] or (index > 0 and nums[index] == nums[index - 1] and not vis[index - 1]):
                continue
            remain.append(nums[index])
            vis[index] = True
            dfs(point + 1, remain)
            vis[index] = False
            remain.pop()

    nums = sorted(nums)
    dfs(0, [])
    return res


if __name__ == '__main__':
    print(permuteUnique([1,2,3]))


