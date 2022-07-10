from typing import List


def lenLongestFibSubseq(arr: List[int]) -> int:
    res, length = 0, len(arr)
    indices = {num: index for index, num in enumerate(arr)}
    dp = [[0] * length for _ in range(length)]
    for i, x in enumerate(arr):
        for j in range(i - 1, -1, -1):
            if arr[j] * 2 <= x:
                break
            if x - arr[j] in indices:
                k = indices[x - arr[j]]
                dp[j][i] = max(dp[k][j] + 1, 3)
                res = max(res, dp[j][i])

    return res




