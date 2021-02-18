def flipLights(n, m):
    n = min(n, 3)
    if m == 0: return 1
    if m == 1: return [2, 3, 4][n - 1]
    if m == 2: return [2, 4, 7][n - 1]
    return [2, 4, 8][n - 1]

if __name__ == "__main__":
    print(flipLights(3, 1))