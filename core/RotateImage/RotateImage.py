from typing import List
from copy import deepcopy


def rotate(matrix: List[List[int]]) -> None:
    remain = deepcopy(matrix)
    n = len(matrix)
    for row in range(n):
        for col in range(n):
            matrix[col][n - 1 - row] = remain[row][col]
