def myAtoi(s: str) -> int:
    left, length = 0, len(s)
    while left < length and s[left] == " ":
        left += 1

    if left >= length:
        return 0

    if s[left] in ["-", "+"]:
        right = left + 1
    else:
        right = left

    while right < length and s[right].isdigit():
        right += 1

    if left == right or (left == right - 1 and s[left] in ["-", "+"]):
        return 0
    res = int(s[left:right])
    if res < -2 ** 31:
        return -2 ** 31
    if res > 2 ** 31 - 1:
        return 2 ** 31 - 1
    return int(s[left:right])


