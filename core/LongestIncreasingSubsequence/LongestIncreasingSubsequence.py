from typing import List

def lengthOfLIS(nums: List[int]) -> int:
    dp = [1] * len(nums)
    def search_index(start, end, num):
        remain = 0
        for i in range(start, end):
            if nums[i] < num and dp[i] > remain:
                remain = dp[i]
        return remain

    res = 0
    for index, item in enumerate(nums):
        dp[index] = search_index(0, index, item) + 1
        res = max(res, dp[index])

    return res
