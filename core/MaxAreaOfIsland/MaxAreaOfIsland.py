from typing import List


def maxAreaOfIsland(grid: List[List[int]]) -> int:
    rows, cols = len(grid), len(grid[0])
    def dfs(row, col):
        if grid[row][col] == 0:
            return 0

        count = 1
        grid[row][col] = 0

        for row_dir, col_dir in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
            new_row, new_col = row + row_dir, col + col_dir
            if 0 <= new_row < rows and 0 <= new_col < cols:
                count += dfs(new_row, new_col)

        return count

    res = 0
    for row in range(rows):
        for col in range(cols):
            res = max(res, dfs(row, col))

    return res



