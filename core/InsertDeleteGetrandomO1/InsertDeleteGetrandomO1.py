from random import choice

class RandomizedSet:

    def __init__(self):
        self.nums = []
        self.index = {}

    def insert(self, val: int) -> bool:
        if val in self.index:
            return False
        self.index[val] = len(self.nums)
        self.nums.append(val)
        return True

    def remove(self, val: int) -> bool:
        if val not in self.index:
            return False
        self.nums[self.index[val]] = self.nums[-1]
        self.index[self.nums[-1]] = self.index[val]
        del self.index[val]
        self.nums.pop()
        return True

    def getRandom(self) -> int:
        return choice(self.nums)




