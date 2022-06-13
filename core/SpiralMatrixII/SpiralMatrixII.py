from typing import List


def generateMatrix(n: int) -> List[List[int]]:
    res = [[0] * n for _ in range(n)]
    row, col, flag = 0, 0, "right"
    for i in range(n ** 2):
        res[row][col] = i + 1
        if flag == "right" and (col + 1 >= n or res[row][col + 1] != 0):
            flag = "down"
            row += 1
        elif flag == "right":
            col += 1
        elif flag == "down" and (row + 1 >= n or res[row + 1][col] != 0):
            flag = "left"
            col -= 1
        elif flag == "down":
            row += 1
        elif flag == "left" and (col - 1 < 0 or res[row][col - 1] != 0):
            flag = "up"
            row -= 1
        elif flag == "left":
            col -= 1
        elif flag == "up" and (row - 1 < 0 or res[row - 1][col] != 0):
            flag = "right"
            col += 1
        else:
            row -= 1

    return res


if __name__ == '__main__':
    print(generateMatrix(3))

