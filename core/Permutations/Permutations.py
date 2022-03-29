from typing import List

def permute(nums: List[int]) -> List[List[int]]:
    res, length = [], len(nums)
    def dfs(start, remain):
        if start >= length:
            res.append(remain.copy())

        for i in range(start, length):
            nums[start], nums[i] = nums[i], nums[start]
            remain.append(nums[start])
            dfs(start + 1, remain)
            remain.pop(-1)
            nums[start], nums[i] = nums[i], nums[start]

    dfs(0, [])
    return res

if __name__ == '__main__':
    print(permute([1,2,3]))


