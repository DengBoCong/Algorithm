from typing import List
import random


def repeatedNTimes(nums: List[int]) -> int:
    while True:
        x, y = random.randint(0, len(nums) - 1), random.randint(0, len(nums) - 1)
        if x != y and nums[x] == nums[y]:
            return nums[x]




