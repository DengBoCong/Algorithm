from typing import List


def imageSmoother(img: List[List[int]]) -> List[List[int]]:
    m, n = len(img), len(img[0])
    res = []
    for row in range(0, m):
        res.append([])
        for col in range(0, n):
            total, count = 0, 0
            for i in range(row - 1, row + 2):
                for j in range(col - 1, col + 2):
                    if 0 <= i < m and 0 <= j < n:
                        total += img[i][j]
                        count += 1
            res[row].append(total // count)

    return res
