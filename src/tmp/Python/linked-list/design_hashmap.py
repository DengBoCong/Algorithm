class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.remain = [[] for _ in range(769)]

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        k = key % 769
        for i in range(len(self.remain[k])):
            if self.remain[k][i][0] == key:
                self.remain[k][i][1] = value
                return
        self.remain[k].append([key, value])


    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        k = key % 769
        for i in range(len(self.remain[k])):
            if self.remain[k][i][0] == key:
                return self.remain[k][i][1]
        
        return -1


    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        k = key % 769
        for i in range(len(self.remain[k])):
            if self.remain[k][i][0] == key:
                del self.remain[k][i]
                break