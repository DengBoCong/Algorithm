def longestCommonSubsequence(text1: str, text2: str) -> int:
    length1, length2 = len(text1), len(text2)
    dp = [[0] * (length2 + 1) for _ in range(length1 + 1)]
    for row in range(1, length1 + 1):
        for col in range(1, length2 + 1):
            if text1[row - 1] == text2[col - 1]:
                dp[row][col] = dp[row - 1][col - 1] + 1
            else:
                dp[row][col] = max(max(dp[row - 1][col - 1], dp[row][col - 1]), dp[row - 1][col])

    return dp[-1][-1]


if __name__ == '__main__':
    print(longestCommonSubsequence(text1 = "abcde", text2 = "ace"))



