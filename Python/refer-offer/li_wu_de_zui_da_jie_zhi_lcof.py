from typing import *

def maxValue(grid: List[List[int]]) -> int:
    if len(grid) == 0 or len(grid[0]) == 0: return 0
    m, n = len(grid), len(grid[0])
    for i in range(1, m) :
        grid[i][0] += grid[i - 1][0]
    for i in range(1, n):
        grid[0][i] += grid[0][i - 1]
    
    for i in range(1, m):
        for j in range(1, n):
            grid[i][j] += max(grid[i - 1][j], grid[i][j - 1])
    
    return grid[m - 1][n - 1]