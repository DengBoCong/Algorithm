from typing import List
from copy import deepcopy


def heightChecker(heights: List[int]) -> int:
    remain = deepcopy(heights)
    remain.sort()
    return len([item1 for item1, item2 in zip(heights, remain) if item1 != item2])
