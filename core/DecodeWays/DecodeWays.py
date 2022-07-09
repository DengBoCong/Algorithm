def numDecodings(s: str) -> int:
    dp = [1] + [0] * len(s)
    for index in range(1, len(s) + 1):
        if s[index - 1] != "0":
            dp[index] = dp[index - 1]
        if index > 1 and s[index - 2] != "0" and 0 < int(s[index - 2:index]) <= 26:
            dp[index] += dp[index - 2]

    return dp[-1]



