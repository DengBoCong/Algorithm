def findTheWinner(n: int, k: int) -> int:
    # winner = 1
    # for i in range(2, n + 1):
    #     winner = (winner + k - 1) % i + 1
    #
    # return winner
    if n == 1:
        return 1
    return (findTheWinner(n - 1, k) + k - 1) % n + 1



