from typing import *

def generateMatrix(n: int) -> List[List[int]]:
    matrix = [[0 for _ in range(n)] for _ in range(n)]
    direct = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    row, col, dir = 0, 0, 0
    for i in range(n * n):
        matrix[row][col] = i + 1
        next_row, next_col = row + direct[dir][0], col + direct[dir][1]
        if next_row < 0 or next_row >= n or next_col < 0 or next_col >= n or matrix[next_row][next_col] != 0:
            dir = (dir + 1) % 4
        row, col = row + direct[dir][0], col + direct[dir][1]
    
    return matrix