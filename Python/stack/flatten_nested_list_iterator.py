def gen(nestedList):
    for ele in nestedList:
        if ele.isInteger():
            yield ele.getInteger()
        else:
            yield from gen(ele.getList())

class NestedIterator:
    def __init__(self, nestedList: [NestedInteger]):
        self.gen = gen(nestedList)
        self.stored = (False, 0)

    def next(self) -> int:
        if not self.hasNext():
            return -1
        result = self.stored[1]
        self.stored = (False, 0)
        return result

    def hasNext(self) -> bool:
        if self.stored[0]:
            return True
        try:
            self.stored = (True, next(self.gen))
            return True
        except:
            return False