def longestCommonSubsequence(text1: str, text2: str) -> int:
    m, n = len(text1), len(text2)
    dp = [0 for _ in range(n + 1)]
    res = 0
    for i in range(m):
        front = 0
        for j in range(1, n + 1):
            temp = dp[j]
            if text1[i] == text2[j - 1]:
                dp[j] = front + 1
            else:
                dp[j] = max(dp[j - 1], front, dp[j])
            front = temp
            res = max(res, dp[j])
    
    return res

if __name__ == "__main__":
    print(longestCommonSubsequence(text1 = "abc", text2 = "def"))
                