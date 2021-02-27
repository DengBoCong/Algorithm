import collections


def dfs(s: str, l: int, r: int, k: int):
    count = collections.Counter()
    for i in range(l, r + 1):
        count[s[i]] += 1

    split = 0
    for num in count.keys():
        if 0 < count[num] < k:
            split = num
            break

    if split == 0:
        return r - l + 1

    i, ret = l, 0
    while i <= r:
        while i <= r and s[i] == split:
            i += 1
        if i > r:
            break
        start = i
        while i <= r and s[i] is not split:
            i += 1

        length = dfs(s, start, i - 1, k)
        ret = max(ret, length)
    return ret


def longestSubstring(s: str, k: int) -> int:
    n = len(s)
    return dfs(s, 0, n - 1, k)

if __name__ == "__main__":
    print(longestSubstring("aaabb", k = 3))