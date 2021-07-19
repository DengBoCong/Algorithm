from typing import List

class NumArray:
    def __init__(self, nums: List[int]):
        self.remain, total = [], 0
        for num in nums:
            total += num
            self.remain.append(total)


    def sumRange(self, i: int, j: int) -> int:
        if i == 0:
            return self.remain[j]
        else:
            return self.remain[j] - self.remain[i - 1]