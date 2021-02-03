import heapq
import collections

class DualHeap:
    def __init__(self, k: int) -> None:
        self.small = list()
        self.large = list()
        self.delayed = collections.Counter()

        self.k = k
        self.smallSize = 0
        self.largeSize = 0
    
    def prune(self, heap: list):
        while heap:
            num = heap[0]
            if heap is self.small:
                num = -num
            if num in self.delayed:
                self.delayed[num] -= 1
                if self.delayed[num] == 0:
                    self.delayed.pop(num)
                heapq.heappop(heap)
            else:
                break
    
    def make_balance(self):
        if self.smallSize > self.largeSize + 1:
            heapq.heappush(self.large, -self.small[0])
            heapq.heappop(self.small)
            self.smallSize -= 1
            self.largeSize += 1
            self.prune(self.small)
        elif self.smallSize < self.largeSize:
            heapq.heappush(self.small, -self.large[0])
            heapq.heappop(self.large)
            self.smallSize += 1
            self.largeSize -= 1
            self.prune(self.large)
    
    def insert(self, num: int):
        if not self.small or num <= -self.small[0]:
            heapq.heappush(self.small, -num)
            self.smallSize += 1
        else:
            heapq.heappush(self.large, num)
            self.largeSize += 1
        self.make_balance()
    
    def erase(self, num: int):
        self.delayed[num] += 1
        if num <= -self.small[0]:
            self.smallSize -= 1
            if num == -self.small[0]:
                self.prune(self.small)
        else:
            self.largeSize -= 1
            if num == self.large[0]:
                self.prune(self.large)
        self.make_balance()

    def get_median(self):
        return float(-self.small[0]) if self.k % 2 == 1 else (-self.small[0] + self.large[0]) / 2


def medianSlidingWindow(nums: list, k: int) -> list:
    result = []
    dual = DualHeap(k=k)
    for i in range(k):
        dual.insert(nums[i])
    
    result.append(dual.get_median())
    for i in range(k, (len(nums))):
        dual.insert(nums[i])
        dual.erase(nums[i - k])
        result.append(dual.get_median())

    return result

if __name__ == "__main__":
    print(medianSlidingWindow(nums = [1,3,-1,-3,5,3,6,7], k = 3))