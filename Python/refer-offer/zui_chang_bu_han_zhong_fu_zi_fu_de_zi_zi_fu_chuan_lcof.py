import collections

def lengthOfLongestSubstring(s: str) -> int:
    left, right, length, res = 0, 0, len(s), 0
    remain = collections.Counter()
    while right < length:
        if remain[s[right]] != 0:
            while remain[s[right]] != 0:
                remain[s[left]] -= 1
                left += 1
        
        remain[s[right]] += 1
        res = max(res, right - left + 1)
        right += 1
    
    return res
