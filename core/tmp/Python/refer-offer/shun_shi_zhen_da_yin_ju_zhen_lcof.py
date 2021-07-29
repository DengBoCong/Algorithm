from typing import *

def spiralOrder(matrix: List[List[int]]) -> List[int]:
    m = len(matrix)
    if m == 0: return []
    n = len(matrix[0])
    if n == 0: return []
    
    direct = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    flag = 0
    res = list()
    
    row, col = 0, 0
    for i in range(m * n):
        res.append(matrix[row][col])
        matrix[row][col] = '1'
        next_row = row + direct[flag][0]
        next_col = col + direct[flag][1]
        if next_row < 0 or next_row >= m or next_col < 0 or next_col >= n or matrix[next_row][next_col] == '1':
            flag = (flag + 1) % 4
        row += direct[flag][0]
        col += direct[flag][1]
    
    return res
