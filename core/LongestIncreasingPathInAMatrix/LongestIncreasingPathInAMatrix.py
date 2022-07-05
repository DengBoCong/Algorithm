from typing import List


def longestIncreasingPath(matrix: List[List[int]]) -> int:
    res, memo = 0, [[0] * len(matrix[0]) for _ in range(len(matrix))]
    rows, cols = len(matrix), len(matrix[0])
    def dfs(row, col):
        if memo[row][col] != 0:
            return memo[row][col]
        memo[row][col] += 1
        for new_row, new_col in [[row + 1, col], [row - 1, col], [row, col + 1], [row, col - 1]]:
            if 0 <= new_row < rows and 0 <= new_col < cols and matrix[new_row][new_col] > matrix[row][col]:
                memo[row][col] = max( memo[row][col], dfs(new_row, new_col) + 1)

        return memo[row][col]

    res = 0
    for i in range(rows):
        for j in range(cols):
            res = max(res, dfs(i, j))

    return res

