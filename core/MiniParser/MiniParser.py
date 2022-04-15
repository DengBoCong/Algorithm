class NestedInteger:
    def __init__(self, value=None):
        """
        If value is not specified, initializes an empty list.
        Otherwise initializes a single integer equal to value.
        """

    def isInteger(self):
        """
        @return True if this NestedInteger holds a single integer, rather than a nested list.
        :rtype bool
        """

    def add(self, elem):
        """
        Set this NestedInteger to hold a nested list and adds a nested integer elem to it.
        :rtype void
        """

    def setInteger(self, value):
        """
        Set this NestedInteger to hold a single integer equal to value.
        :rtype void
        """

    def getInteger(self):
        """
        @return the single integer that this NestedInteger holds, if it holds a single integer
        Return None if this NestedInteger holds a nested list
        :rtype int
        """

    def getList(self):
        """
        @return the nested list that this NestedInteger holds, if it holds a nested list
        Return None if this NestedInteger holds a single integer
        :rtype List[NestedInteger]
        """

def deserialize(self, s: str) -> NestedInteger:
    index = 0

    def dfs() -> NestedInteger:
        nonlocal index
        if s[index] == '[':
            index += 1
            ni = NestedInteger()
            while s[index] != ']':
                ni.add(dfs())
                if s[index] == ',':
                    index += 1
            index += 1
            return ni
        else:
            negative = False
            if s[index] == '-':
                negative = True
                index += 1
            num = 0
            while index < len(s) and s[index].isdigit():
                num *= 10
                num += int(s[index])
                index += 1
            if negative:
                num = -num
            return NestedInteger(num)

    return dfs()
