from typing import List

def spiralOrder(matrix: List[List[int]]) -> List[int]:
    res, direct, dir_step = [], 0, [[0, 1], [1, 0], [0, -1], [-1, 0]]
    rows, cols, row, col = len(matrix), len(matrix[0]), 0, 0
    while 0 <= row < rows and 0 <= col < cols and matrix[row][col] != 1000:
        res.append(matrix[row][col])
        matrix[row][col] = 1000
        next_row, next_col = row + dir_step[direct][0], col + dir_step[direct][1]
        if not (0 <= next_row < rows and 0 <= next_col < cols and matrix[next_row][next_col] != 1000):
            direct = (direct + 1) % 4

        row += dir_step[direct][0]
        col += dir_step[direct][1]

    return res



