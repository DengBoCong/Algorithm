from typing import List


def shortestToChar(s: str, c: str) -> List[int]:
    left, right, length = 0, 1, len(s)
    res = [0] * length
    while right < length:

        while right < length and s[right] != c:
            if s[left] == c:
                res[right] = min(res[right], abs(right - left)) if res[right] != 0 else abs(right - left)
            right += 1

        while length > right > left:
            if res[left] != 0:
                res[left] = min(res[left], abs(right - left))
            elif s[left] != c:
                res[left] = abs(right - left)
            left += 1

        right += 1

    return res


if __name__ == '__main__':
    print(shortestToChar(s = "loveleetcode", c = "e"))

