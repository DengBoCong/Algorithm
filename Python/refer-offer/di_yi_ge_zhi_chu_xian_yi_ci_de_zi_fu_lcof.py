import collections

def firstUniqChar(s: str) -> str:
    length = len(s)
    remain = collections.Counter()
    for i in range(length):
        remain[s[i]] += 1
    for i in range(length):
        if remain[s[i]] == 1:
            return s[i]
    
    return " "