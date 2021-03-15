from typing import *

def spiralOrder(matrix: List[List[int]]) -> List[int]:
    result = []
    row, col, direct = 0, 0, 0
    dir = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    m, n = len(matrix), len(matrix[0])
    for i in range(m * n):
        result.append(matrix[row][col])
        matrix[row][col] = 1000
        next_row, next_col = row + dir[direct][0], col + dir[direct][1]
        if next_row < 0 or next_row >= m or next_col < 0 or next_col >= n or matrix[next_row][next_col] == 1000:
            direct = (direct + 1) % 4
        row, col = row + dir[direct][0], col + dir[direct][1]
    
    return result
        
