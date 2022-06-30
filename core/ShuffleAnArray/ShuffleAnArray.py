import random
from typing import List
from copy import deepcopy
from random import randint

class Solution:

    def __init__(self, nums: List[int]):
        self.nums = nums
        self.shuffle_nums = deepcopy(self.nums)

    def reset(self) -> List[int]:
        self.shuffle_nums = deepcopy(self.nums)
        return self.shuffle_nums

    def shuffle(self) -> List[int]:
        for i in range(len(self.nums) - 1):
            point = randint(i, len(self.nums) - 1)
            self.shuffle_nums[point], self.shuffle_nums[i] = self.shuffle_nums[i], self.shuffle_nums[point]

        return self.shuffle_nums




