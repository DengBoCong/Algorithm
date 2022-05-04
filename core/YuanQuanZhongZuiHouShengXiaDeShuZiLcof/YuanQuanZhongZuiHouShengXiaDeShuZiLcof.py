def lastRemaining(n: int, m: int) -> int:
    winner = 0
    for i in range(1, n):
        winner = (winner + m) % (i + 1)

    return winner




