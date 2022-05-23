from typing import List
from collections import deque


def cutOffTree(forest: List[List[int]]) -> int:
    def bfs(dest_x, dest_y, ori_x, ori_y):
        rows, cols = len(forest), len(forest[0])
        queue, vis = deque([(0, ori_x, ori_y)]), {(ori_x, ori_y)}
        while queue:
            dist, x, y = queue.popleft()
            if x == dest_x and y == dest_y:
                return dist
            for row, col in [(x - 1, y), (x + 1, y), (x, y + 1), (x, y - 1)]:
                if 0 <= row < rows and 0 <= col < cols and forest[row][col] != 0 and (row, col) not in vis:
                    vis.add((row, col))
                    queue.append((dist + 1, row, col))

        return -1

    trees = sorted([(forest[row][col], row, col) for row, _ in enumerate(forest) for col, val in enumerate(forest[row]) if val > 1])
    ans, pre_x, pre_y = 0, 0, 0
    for _, dest_x, dest_y in trees:
        res = bfs(dest_x, dest_y, pre_x, pre_y)
        if res < 0:
            return -1
        ans += res
        pre_x, pre_y = dest_x, dest_y

    return ans




