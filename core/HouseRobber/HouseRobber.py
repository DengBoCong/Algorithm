from typing import List


def rob(nums: List[int]) -> int:
    length = len(nums)
    dp = [0] * length
    for index in range(length):
        pre_pre_house = 0 if index - 2 < 0 else dp[index - 2]
        pre_house = 0 if index - 1 < 0 else dp[index - 1]
        dp[index] = max(pre_pre_house + nums[index], pre_house)

    return dp[-1]
