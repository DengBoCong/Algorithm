from typing import List


def minCost(costs: List[List[int]]) -> int:
    first, second, third = 0, 0, 0
    for item1, item2, item3 in costs:
        item1 += min(second, third)
        item2 += min(first, third)
        item3 += min(first, second)
        first, second, third = item1, item2, item3

    return min(first, min(second, third))





