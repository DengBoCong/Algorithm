

def longestSubstring(s: str, k: int) -> int:
    def dfs(left, right):
        cnt = [0] * 26
        for i in range(left, right + 1):
            cnt[ord(s[i]) - ord("a")] += 1

        split = 0
        for i in range(26):
            if 0 < cnt[i] < k:
                split = chr(i + 97)
                break
        if split == 0:
            return right - left + 1

        i, ret = left, 0
        while i <= right:
            while i <= right and s[i] == split:
                i += 1
            if i > right:
                break

            start = i
            while i <= right and s[i] != split:
                i += 1
            length = dfs(start, i - 1)
            ret = max(ret, length)

        return ret

    return dfs(0, len(s) - 1)

if __name__ == '__main__':
    print(longestSubstring(s = "ababbc", k = 2))
