class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.mod = 1000
        self.bucket = [[] for _ in range(self.mod)]


    def add(self, key: int) -> None:
        k = key % self.mod
        if key not in self.bucket[k]:
            self.bucket[k].append(key)


    def remove(self, key: int) -> None:
        k = key % self.mod
        if key in self.bucket[k]:
            self.bucket[k].remove(key)


    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        k = key % self.mod
        return key in self.bucket[k]