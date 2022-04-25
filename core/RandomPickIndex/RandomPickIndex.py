from random import choice
from typing import List


class Solution:

    def __init__(self, nums: List[int]):
        self.remain = {}
        for index, num in enumerate(nums):
            if num not in self.remain:
                self.remain[num] = [index]
            else:
                self.remain[num].append(index)

    def pick(self, target: int) -> int:
        return choice(self.remain[target])
