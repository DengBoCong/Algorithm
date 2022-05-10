from typing import List


def uniquePathsWithObstacles(obstacleGrid: List[List[int]]) -> int:
    rows, cols = len(obstacleGrid), len(obstacleGrid[0])
    dp = [1] * (cols + 1)
    for col in range(cols):
        if obstacleGrid[0][col] == 1:
            dp[col + 1] = 0
        else:
            dp[col + 1] = dp[col]
    dp[0] = 0
    for row in range(1, rows):
        for col in range(1, cols + 1):
            if obstacleGrid[row][col - 1] == 1:
                dp[col] = 0
            else:
                dp[col] = dp[col] + dp[col - 1]

    return dp[-1]



