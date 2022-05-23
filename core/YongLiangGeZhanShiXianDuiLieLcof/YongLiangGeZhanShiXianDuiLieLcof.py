class CQueue:
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def appendTail(self, value: int) -> None:
        while self.stack2:
            self.stack1.append(self.stack2.pop())
        self.stack1.append(value)

    def deleteHead(self) -> int:
        while self.stack1:
            self.stack2.append(self.stack1.pop())
        return self.stack2.pop() if self.stack2 else -1
