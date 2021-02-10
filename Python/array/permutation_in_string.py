import collections

def checkInclusion(s1: str, s2: str) -> bool:
    n = len(s1)
    count = collections.Counter()
    for ch in s1:
        count[ch] += 1
    
    remain = collections.Counter()
    left = 0
    for i in range(len(s2)):
        remain[s2[i]] += 1
        if count[s2[i]] == 0:
            left = i + 1
            remain.clear()
        elif remain[s2[i]] > count[s2[i]]:
            while remain[s2[i]] > count[s2[i]]:
                remain[s2[left]] -= 1
                left += 1
        else:
            if n == i - left + 1:
                return True
    
    return False
            




if __name__ == "__main__":
    print(checkInclusion(s1 = "adc", s2 = "dcda"))