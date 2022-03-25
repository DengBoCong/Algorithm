def trailingZeroes(n: int) -> int:
    res = 0
    for i in range(5, n + 1, 5):
        while i % 5 == 0:
            res += 1
            i //= 5

    return res


if __name__ == '__main__':
    print(trailingZeroes(30))
