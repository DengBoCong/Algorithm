from typing import List


def projectionArea(grid: List[List[int]]) -> int:
    rows, cols = len(grid), len(grid[0])
    row_max, col_max = [0] * rows, [0] * rows
    res = 0
    for row in range(rows):
        for col in range(cols):
            if grid[row][col] != 0:
                res += 1
                row_max[row] = max(row_max[row], grid[row][col])
                col_max[col] = max(col_max[col], grid[row][col])

    return res + sum(row_max) + sum(col_max)





