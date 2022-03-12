def nearestPalindromic(n: str) -> str:
    left, right, temp, length = 0, len(n) - 1, list(n), len(n)
    int_n = int(n)
    candidate = [10 ** (length - 1) - 1, 10 ** length + 1]
    self_prefix = int(n[:(length + 1) // 2])
    for prefix in range(self_prefix - 1, self_prefix + 2):
        y = prefix if length % 2 == 0 else prefix // 10
        while y != 0:
            prefix = prefix * 10 + y % 10
            y //= 10
        candidate.append(prefix)

    res = -1
    for candi in candidate:
        if str(candi) != n:
            if res == -1 or abs(int_n - candi) < abs(int_n - res):
                res = candi

    return str(res)


if __name__ == '__main__':
    print(nearestPalindromic("1283"))
