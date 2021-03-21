from typing import *

def setZeroes(matrix: List[List[int]]) -> None:
    row, col = len(matrix), len(matrix[0])
    remain_row, remain_col = False, False
    for i in range(row):
        if matrix[i][0] == 0:
            remain_row = True
            break
    
    for i in range(col):
        if matrix[0][i] == 0:
            remain_col = True
            break
    
    for i in range(1, row):
        for j in range(1, col):
            if matrix[i][j] == 0:
                matrix[i][0], matrix[0][j] = 0, 0
    
    for i in range(1, row):
        for j in range(1, col):
            if matrix[i][0] == 0 or matrix[0][j] == 0:
                matrix[i][j] = 0
    
    if remain_row:
        for i in range(row):
            matrix[i][0] = 0
    
    if remain_col:
        for i in range(col):
            matrix[0][i] = 0