def isMatch(s: str, p: str) -> bool:
    m, n = len(s), len(p)
    def matchs(i: int, j: int) -> bool:
        if i == 0:
            return False
        if p[j - 1] == '.':
            return True
        return s[i - 1] == p[j - 1]
    
    f = [[False] * (n + 1) for _ in range(m + 1)]
    f[0][0] = True
    for i in range(m + 1):
        for j in range(1, n + 1):
            if p[j - 1] == '*':
                f[i][j] |= f[i][j - 2]
                if matchs(i, j - 1):
                    f[i][j] |= f[i - 1][j]
            else:
                if matchs(i, j):
                    f[i][j] |= f[i - 1][j - 1]
    return f[m][n]

if __name__ == "__main__":
    print(False | True)