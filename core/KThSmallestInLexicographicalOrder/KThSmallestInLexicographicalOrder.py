def getSteps(self, cur: int, n: int) -> int:
    steps, first, last = 0, cur, cur
    while first <= n:
        steps += min(last, n) - first + 1
        first *= 10
        last = last * 10 + 9
    return steps


def findKthNumber(self, n: int, k: int) -> int:
    cur = 1
    k -= 1
    while k:
        steps = self.getSteps(cur, n)
        if steps <= k:
            k -= steps
            cur += 1
        else:
            cur *= 10
            k -= 1
    return cur