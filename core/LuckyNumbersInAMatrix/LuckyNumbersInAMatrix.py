from typing import List


def luckyNumbers(matrix: List[List[int]]) -> List[int]:
    ans = []
    for row in matrix:
        for j, x in enumerate(row):
            if max(r[j] for r in matrix) <= x <= min(row):
                ans.append(x)
    return ans
