from typing import List


def minDeletionSize(strs: List[str]) -> int:
    rows, cols = len(strs), len(strs[0])
    count = 0
    for col in range(cols):
        for row in range(rows):
            if row != 0 and ord(strs[row][col]) < ord(strs[row - 1][col]):
                count += 1
                break

    return count




