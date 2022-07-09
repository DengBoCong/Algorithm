import heapq


class MedianFinder:

    def __init__(self):
        self.heap1 = []
        self.heap2 = []

    def addNum(self, num: int) -> None:
        if not self.heap2 or num <= -self.heap2[0]:
            heapq.heappush(self.heap2, -num)
            if len(self.heap1) + 1 < len(self.heap2):
                heapq.heappush(self.heap1, -heapq.heappop(self.heap2))
        else:
            heapq.heappush(self.heap1, num)
            if len(self.heap1) > len(self.heap2):
                heapq.heappush(self.heap2, -heapq.heappop(self.heap1))

    def findMedian(self) -> float:
        if len(self.heap1) == len(self.heap2):
            return (self.heap1[0] - self.heap2[0]) / 2
        else:
            return -self.heap2[0]





