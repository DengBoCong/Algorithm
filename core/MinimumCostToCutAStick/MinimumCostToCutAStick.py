from typing import List


def minCost(n: int, cuts: List[int]) -> int:
    m = len(cuts)
    cuts = [0] + sorted(cuts) + [n]
    f = [[0] * (m + 2) for _ in range(m + 2)]

    for i in range(m, 0, -1):
        for j in range(i, m + 1):
            f[i][j] = 0 if i == j else min(f[i][k - 1] + f[k + 1][j] for k in range(i, j + 1))
            f[i][j] += cuts[j + 1] - cuts[i - 1]

    return f[1][m]


if __name__ == '__main__':
    print(minCost(n = 7, cuts = [1,3,4,5]))
