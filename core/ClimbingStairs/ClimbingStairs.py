def climbStairs(n: int) -> int:
    if n < 4:
        return n
    pre, cur = 2, 3
    for _ in range(3, n):
        temp = cur
        cur = pre + cur
        pre = temp

    return cur




