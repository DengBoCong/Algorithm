def longestValidParentheses(s: str) -> int:
    res, length = 0, len(s)
    dp = [0] * length
    for i in range(1, length):
        if s[i - 1:i + 1] == "()":
            dp[i] = 2 if i - 2 < 0 else dp[i - 2] + 2

        if s[i - 1:i + 1] == "))" and i - dp[i - 1] > 0 and s[i - dp[i - 1] - 1] == "(":
            pre_len = 0 if i - dp[i - 1] - 2 < 0 else dp[i - dp[i - 1] - 2]
            dp[i] = dp[i - 1] + pre_len + 2

        res = max(res, dp[i])
    return res


if __name__ == '__main__':
    print(longestValidParentheses(")(((((()())()()))()(()))("))
