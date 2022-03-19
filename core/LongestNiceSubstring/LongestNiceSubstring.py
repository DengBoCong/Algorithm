def longestNiceSubstring(s: str) -> str:
    length = len(s)
    max_pos, max_len = 0, 0
    for i in range(length):
        lower, upper = 0, 0
        for j in range(i, length):
            if s[j].islower():
                lower |= 1 << (ord(s[j]) - ord("a"))
            else:
                upper |= 1 << (ord(s[j]) - ord("A"))
            if lower == upper and j - i + 1 > max_len:
                max_len = j - i + 1
                max_pos = i

    return s[max_pos:max_pos + max_len]
