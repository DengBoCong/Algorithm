from collections import deque

class MyStack:

    def __init__(self):
        self.queue1 = deque()
        self.queue2 = deque()

    def push(self, x: int) -> None:
        if len(self.queue1) == 0:
            self.queue1.append(x)
            while self.queue2:
                self.queue1.append(self.queue2.popleft())
        else:
            self.queue2.append(x)
            while self.queue1:
                self.queue2.append(self.queue1.popleft())

    def pop(self) -> int:
        if self.queue1:
            return self.queue1.popleft()
        else:
            return self.queue2.popleft()

    def top(self) -> int:
        if self.queue1:
            return self.queue1[0]
        else:
            return self.queue2[0]

    def empty(self) -> bool:
        return len(self.queue1) == 0 and len(self.queue2) == 0
