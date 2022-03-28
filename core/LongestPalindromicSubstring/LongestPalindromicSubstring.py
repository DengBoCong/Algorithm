def longestPalindrome(s: str) -> str:
    length = len(s)
    def cal_str(left, right):
        while left >= 0 and right < length and s[left] == s[right]:
            left -= 1
            right += 1

        return s[left + 1:right]

    res = s[0]
    for i in range(length - 1):
        sub_str = ""
        if i + 1 < length:
            sub_str = cal_str(i, i + 1)
        res = sub_str if len(sub_str) > len(res) else res
        if i + 2 < length:
            sub_str = cal_str(i, i + 2)
        res = sub_str if len(sub_str) > len(res) else res

    return res
