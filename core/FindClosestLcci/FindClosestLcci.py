from typing import List


def findClosest(words: List[str], word1: str, word2: str) -> int:
    res, point1, point2 = -1, -1, -1
    for index, word in enumerate(words):
        if word == word1:
            point1 = index
        if word == word2:
            point2 = index

        if point1 != -1 and point2 != -1:
            res = abs(point1 - point2) if res == -1 else min(res, abs(point1 - point2))

    return res




