def equalSubstring(s: str, t: str, maxCost: int) -> int:
    length = len(s)
    left, right, sum, result = 0, 0, 0, 0

    while right < length:
        sum += abs(ord(s[right]) - ord(t[right]))
        if sum <= maxCost:
            result = max(result, right - left + 1)
        else:
            sum -= abs(ord(s[left]) - ord(t[left]))
            left += 1
        right += 1
    
    return result
    
if __name__ == "__main__":
    print(equalSubstring(s = "krrgw", t = "zjxss", maxCost = 19))