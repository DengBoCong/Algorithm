from typing import List


def maximalSquare(matrix: List[List[str]]) -> int:
    rows, cols = len(matrix) + 1, len(matrix[0]) + 1
    res, dp, remain = 0, [0] * cols, 0
    for row in range(1, rows):
        for col in range(1, cols):
            temp = dp[col]
            if matrix[row - 1][col - 1] == "0":
                dp[col] = 0
            else:
                dp[col] = min(min(dp[col - 1], temp), remain) + 1
            remain = temp
            res = max(res, dp[col])

    return res ** 2





