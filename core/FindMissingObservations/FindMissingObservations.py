from typing import List


def missingRolls(rolls: List[int], mean: int, n: int) -> List[int]:
    m, sum_m = len(rolls), sum(rolls)
    sum_n = (m + n) * mean - sum_m
    if sum_n > n * 6 or sum_n < n:
        return []

    if sum_n // n == sum_n / n:
        return [sum_n // n] * n

    res, count = [], 0
    while sum_n >= n:
        count += 1
        sum_n -= n
    for i in range(n - sum_n):
        res.append(count)
    for i in range(sum_n):
        res.append(count + 1)

    return res

if __name__ == '__main__':
    print(missingRolls(rolls = [4,5,6,2,3,6,5,4,6,4,5,1,6,3,1,4,5,5,3,2,3,5,3,2,1,5,4,3,5,1,5], mean = 4, n = 40))



