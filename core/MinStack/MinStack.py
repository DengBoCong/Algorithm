import heapq

class MinStack:
    def __init__(self):
        self.stack = []
        self.queue = []
        self.count = 0
        self.remain = set()

    def push(self, val: int) -> None:
        self.stack.append([val, self.count])
        heapq.heappush(self.queue, (val, self.count))
        self.count += 1

    def pop(self) -> None:
        val, count = self.stack.pop()
        self.remain.add(count)
        return val

    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        while self.queue and self.queue[0][1] in self.remain:
            self.remain.remove(heapq.heappop(self.queue)[1])
        return self.queue[0][0]



