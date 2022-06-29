from typing import List

def findNumberIn2DArray(matrix: List[List[int]], target: int) -> bool:
    if len(matrix) == 0 or len(matrix[0]) == 0:
        return False
    row, col = len(matrix), len(matrix[0])
    x, y = 0, col - 1
    while x < row and y >= 0:
        if matrix[x][y] == target:
            return True
        elif matrix[x][y] < target:
            x += 1
        else:
            y -= 1

    return False







