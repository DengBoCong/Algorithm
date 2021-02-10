import collections
from typing import List

def findAnagrams(s: str, p: str) -> List[int]:
    n = len(p)
    count = collections.Counter()
    remain = collections.Counter()
    for ch in p:
        count[ch] += 1
    
    left = 0
    result = []
    for i in range(len(s)):
        if count[s[i]] == 0:
            left = i + 1
            remain.clear()
            continue
        remain[s[i]] += 1
        while remain[s[i]] > count[s[i]]:
            remain[s[left]] -= 1
            left += 1
        if i - left + 1 == n:
            result.append(left)
            remain[s[left]] -= 1
            left += 1
    
    return result

if __name__ == "__main__":
    print(findAnagrams(s="abab", p="ab"))

        