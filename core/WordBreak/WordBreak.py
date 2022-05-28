from typing import List


def wordBreak(s: str, wordDict: List[str]) -> bool:
    dp = [False] * len(s)
    for index, _ in enumerate(s):
        for point in range(index, -1, -1):
            if s[point:index + 1] in wordDict and (point == 0 or dp[point - 1]):
                dp[index] = True
                break
    return dp[-1]






