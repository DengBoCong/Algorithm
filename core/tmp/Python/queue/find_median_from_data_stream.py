import heapq
import collections

class MedianFinder:

    def __init__(self, k: int):
        """
        initialize your data structure here.
        """
        self.k = k
        self.small = list()
        self.large = list()
        self.small_size = 0
        self.large_size = 0
        self.delayed = collections.Counter()
    
    def _make_balance(self) -> None:
        if self.small_size > self.large_size + 1:
            heapq.heappush(self.large, self.small[0])
            heapq.heappop(self.small)
            self._purse(self.small)
            self.small_size -= 1
            self.large_size += 1
        elif self.small_size < self.large_size:
            heapq.heappush(self.small, self.large[0])
            heapq.heappop(self.large)
            self._purse(self.large)
            self.small_size += 1
            self.large_size -= 1
            
    
    def _purse(self, heaq: list) -> None:
        while heapq:
            if heapq[0] in self.delayed:
                self.delayed[heapq[0]] -= 1
                if self.delayed[heapq[0]] == 0:
                    self.delayed.pop(heapq[0])
                heapq.heappop(heapq)
            else:
                break


    def addNum(self, num: int) -> None:
        if not self.small and num <= -self.small[0]:
            heapq.heappush(self.small, -num)
            self.small_size += 1
        else:
            heapq.heappush(self.large, num)
            self.large_size += 1
        self._make_balance()

    def findMedian(self) -> float:
        return self.small[0] if self.k % 2 == 1 else (float(self.small[0]) + float(self.large[0])) / 2