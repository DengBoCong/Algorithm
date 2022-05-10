def uniquePaths(m: int, n: int) -> int:
    dp = [0] + [1] * n
    for row in range(1, m):
        for col in range(1, n + 1):
            if row == 1 and col == 1:
                continue
            dp[col] = dp[col - 1] + dp[col]

    return dp[-1]



