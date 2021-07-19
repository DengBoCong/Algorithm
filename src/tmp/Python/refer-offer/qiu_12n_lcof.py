def sumNums(self, n: int) -> int:
    self.res = 0
    def dfs(n: int):
        n > 0 and dfs(n - 1)
        self.res += n
    dfs(n)
    return self.res