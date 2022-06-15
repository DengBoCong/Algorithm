def reverse(x: int) -> int:
    res, max_int, min_int = 0, 2 ** 31 - 1, -2 ** 31
    while x != 0:
        if res < min_int // 10 + 1 or res > max_int // 10:
            return 0
        digit = x % 10
        if x < 0 and digit > 0:
            digit -= 10
        res = res * 10 + digit
        x = (x - digit) // 10

    return res



