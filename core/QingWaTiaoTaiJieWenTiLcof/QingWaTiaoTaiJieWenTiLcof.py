def numWays(n: int) -> int:
    pre, cur = 1, 1
    for i in range(2, n + 1):
        cur, pre = cur + pre, cur

    return cur % 1000000007


if __name__ == '__main__':
    print(numWays(5))

