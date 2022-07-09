from typing import List


def minCostToMoveChips(position: List[int]) -> int:
    odd_count, count = 0, 0
    for num in position:
        if num % 2 == 0:
            odd_count += 1
        else:
            count += 1

    return min(odd_count, count)


