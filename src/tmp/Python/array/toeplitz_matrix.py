from typing import List

def isToeplitzMatrix(matrix: List[List[int]]) -> bool:
    row = len(matrix)
    col = len(matrix[0])
    for i in range(row):
        r, c = i, 0
        while r + 1 < row and c + 1 < col:
            if matrix[r][c] != matrix[r + 1][c + 1]:
                return False
            r += 1
            c += 1
    for i in range(1, col):
        r, c = 0, i
        while r + 1 < row and c + 1 < col:
            if matrix[r][c] != matrix[r + 1][c + 1]:
                return False
            r += 1
            c += 1
    return True

if __name__ == "__main__":
    print(isToeplitzMatrix([[1,2],[2,2]]))
