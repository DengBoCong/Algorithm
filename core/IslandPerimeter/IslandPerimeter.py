from typing import List
from collections import deque


def islandPerimeter(grid: List[List[int]]) -> int:
    rows, cols = len(grid), len(grid[0])
    res = 0
    for row in range(rows):
        for col in range(cols):
            if grid[row][col] == 1:
                queue = deque([(row, col)])
                grid[row][col] = -1
                while queue:
                    step_row, step_col = queue.popleft()
                    for row_dir, col_dir in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
                        new_row, new_col = step_row + row_dir, step_col + col_dir
                        if 0 <= new_row < rows and 0 <= new_col < cols:
                            if grid[new_row][new_col] == 1:
                                queue.append((new_row, new_col))
                                grid[new_row][new_col] = -1
                            elif grid[new_row][new_col] == 0:
                                res += 1
                        else:
                            res += 1
                return res

    return 0


if __name__ == '__main__':
    print(islandPerimeter([[1,1],[1,1]]))


