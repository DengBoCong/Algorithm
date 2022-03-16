from typing import List


def findBall(grid: List[List[int]]) -> List[int]:
    row_length, col_length = len(grid), len(grid[0])

    def dfs(row, col, flag, visited):
        if row * col_length + col in visited or col < 0 or col >= col_length:
            return -1
        if row == row_length:
            return col
        visited.append(row * col_length + col)
        if (flag == "up" or flag == "right") and grid[row][col] == 1:
            return dfs(row, col + 1, "left", visited)
        if (grid[row][col] == 1 and flag == "left") or (grid[row][col] == -1 and flag == "right"):
            return dfs(row + 1, col, "up", visited)
        if (flag == "up" or flag == "left") and grid[row][col] == -1:
            return dfs(row, col - 1, "right", visited)

    res = []
    for i in range(col_length):
        res.append(dfs(0, i, "up", []))

    return res


if __name__ == '__main__':
    print(findBall([[1, 1, 1, 1, 1, 1], [-1, -1, -1, -1, -1, -1], [1, 1, 1, 1, 1, 1], [-1, -1, -1, -1, -1, -1]]))
