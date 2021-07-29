def lastRemaining(n: int, m: int) -> int:
    x = 0
    for i in range(2, n + 1):
        x = (x + m) % i
    return x