def minDistance(word1: str, word2: str) -> int:
    m, n = len(word1), len(word2)
    if m == 0 or n == 0:
        return max(m, n)

    dp = [[0] * (n + 1) for _ in range(m + 1)]
    for i in range(n):
        dp[0][i + 1] = i + 1
    for i in range(m):
        dp[i + 1][0] = i + 1

    for row in range(1, m + 1):
        for col in range(1, n + 1):
            left = dp[row][col - 1] + 1
            down = dp[row - 1][col] + 1
            left_down = dp[row - 1][col - 1]
            if word1[row - 1] != word2[col - 1]:
                left_down += 1

            dp[row][col] = min(min(left, left_down), down)

    return dp[-1][-1]


if __name__ == '__main__':
    print(minDistance(word1 = "intention", word2 = "execution"))


