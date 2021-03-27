import math

def cuttingRope(n: int) -> int:
    if n <= 3: return n - 1
    a, b, p = n // 3, n % 3, 1000000007
    if b == 0: return 3 ** a % p
    if b == 1: return 3 ** (a - 1) * 4 % p
    return 3 ** a * 2 % p

if __name__ == "__main__":
    print(cuttingRope(10))