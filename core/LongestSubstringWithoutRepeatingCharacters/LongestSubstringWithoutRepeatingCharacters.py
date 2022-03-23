from collections import Counter

def lengthOfLongestSubstring(s: str) -> int:
    counter = Counter()
    left, right, length = 0, 0, len(s)
    res = 0
    while right < length:
        counter[s[right]] += 1
        while counter[s[right]] >= 2:
            counter[s[left]] -= 1
            left += 1

        res = max(res, right - left + 1)
        right += 1

    return res



