import random
from typing import List

class Solution:
    def __init__(self, n: int, blacklist: List[int]):
        self.map = {}
        self.length = n - len(blacklist)
        for black in blacklist:
            if black < self.length:
                while n - 1 in blacklist:
                    n -= 1
                self.map[black] = n - 1
                n -= 1

    def pick(self) -> int:
        point = random.randint(0, self.length - 1)
        return point if point not in self.map else self.map[point]




