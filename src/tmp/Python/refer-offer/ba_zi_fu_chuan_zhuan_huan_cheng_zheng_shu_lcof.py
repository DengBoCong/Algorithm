def strToInt(str: str) -> int:
    res, i, sign, length = 0, 0, 1, len(str)
    int_max, int_min, bndry = 2 ** 31 - 1, -2 ** 31, 2 ** 31 // 10
    if not str: return 0
    while str[i] == ' ':
        i += 1
        if i == length: return 0
    if str[i] == '-': sign = -1
    if str[i] in '+-': i += 1
    for c in str[i:]:
        if not '0' <= c <= '9' : break
        if res > bndry or res == bndry and c > '7':
            return int_max if sign == 1 else int_min
        res = 10 * res + ord(c) - ord('0')
    return sign * res