from typing import List


def calculateMinimumHP(dungeon: List[List[int]]) -> int:
    res, rows, cols = 0, len(dungeon), len(dungeon[0])
    big = 10**9
    dp = [[big] * (cols + 1) for _ in range(rows + 1)]
    dp[rows][cols - 1] = dp[rows - 1][cols] = 1
    for i in range(rows - 1, -1, -1):
        for j in range(cols - 1, -1, -1):
            minn = min(dp[i + 1][j], dp[i][j + 1])
            dp[i][j] = max(minn - dungeon[i][j], 1)

    return dp[0][0];

if __name__ == '__main__':
    print(calculateMinimumHP([[0,5],[-2,-3]]))



