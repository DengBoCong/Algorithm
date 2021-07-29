def minWindow(s: str, t: str) -> str:
    length = len(t)
    left, right, min_length = -1, -1, 100000

    restore = {}
    remain = {}
    for alpha in t:
        restore[alpha] = 1 if restore.get(alpha, -1) == -1 else restore[alpha] + 1
        remain[alpha] = 0

    i, j, count = 0, 0, 0
    flag = True
    while i <= j and j < len(s):
        if flag and remain.get(s[j], -1) != -1:
            remain[s[j]] += 1
            if remain[s[j]] <= restore[s[j]]:
                count += 1
        if count == length:
            if min_length > j - i + 1:
                left, right = i, j
                min_length = j - i + 1
            if remain.get(s[i], -1) != -1:
                remain[s[i]] -= 1
                if remain[s[i]] < restore[s[i]]:
                    count -= 1
            
            i += 1

        if count == length:
            flag = False
        else:
            flag = True
            j += 1

    if min_length == 100000:
        return ""
    else:
        return s[left:right+1]


if __name__ == "__main__":
    print(minWindow(s = "ADOBECODEBANC", t = "ABC"))
