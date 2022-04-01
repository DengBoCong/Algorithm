from typing import List


def trap(height: List[int]) -> int:
    length = len(height)
    left_dp, right_dp = [0] * length, [0] * length
    for index in range(1, length):
        left_dp[index] = max(left_dp[index - 1], height[index - 1])
    for index in range(length - 2, -1, -1):
        right_dp[index] = max(right_dp[index + 1], height[index + 1])
    res = 0
    for index in range(1, length - 1):
        if left_dp[index] > height[index] and right_dp[index] > height[index]:
            res += min(left_dp[index], right_dp[index]) - height[index]

    return res


