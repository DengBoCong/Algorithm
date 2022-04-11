def countNumbersWithUniqueDigits(n: int) -> int:
    if n == 0:
        return 1
    res = 1
    for i in range(1, n + 1):
        mid, start = 9, 9
        while i > 1:
            mid *= start
            i -= 1
            start -= 1

        res += mid

    return res


if __name__ == '__main__':
    print(countNumbersWithUniqueDigits(3))
