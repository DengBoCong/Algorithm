from typing import List


def numIslands(grid: List[List[str]]) -> int:
    res, rows, cols = 0, len(grid), len(grid[0])

    def dfs(i, j):
        if grid[i][j] == "0" or i < 0 or i >= rows or j < 0 or j >= cols:
            return
        grid[i][j] = "0"
        for r, c in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
            dfs(i + r, c + j)

    for row in range(rows):
        for col in range(cols):
            if grid[row][col] == "1":
                res += 1
                dfs(row, col)

    return res
