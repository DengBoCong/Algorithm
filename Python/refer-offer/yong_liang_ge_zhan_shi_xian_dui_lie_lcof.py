class CQueue:

    def __init__(self):
        self.stack_front = list()
        self.stack_back = list()


    def appendTail(self, value: int) -> None:
        while self.stack_back:
            self.stack_front.append(self.stack_back.pop())
        
        self.stack_front.append(value)

    def deleteHead(self) -> int:
        while self.stack_front:
            self.stack_back.append(self.stack_front.pop())
        
        if self.stack_back:
            return self.stack_back.pop()
        else:
            return -1