def convert(s: str, numRows: int) -> str:
    if numRows == 1:
        return s
    
    row = min(len(s), numRows)
    remain = [[] for i in range(row)]
    r, flag = 0, False
    for i, ch in enumerate(s):
        remain[r].append(ch)
        if r == 0 or r == row - 1:
            flag = not flag
        if flag:
            r += 1
        else:
            r -= 1
    result = []
    for i in range(row):
        result.extend(remain[i])
    return "".join(result)

if __name__ == "__main__":
    print(convert(s = "A", numRows = 1))