import math

def cuttingRope(n: int) -> int:
    if n <= 3: return n - 1
    a, b = n // 3, n % 3
    if b == 0: return int(math.pow(3, a))
    if b == 1: return int(math.pow(3, a - 1) * 4)
    return int(math.pow(3, a) * 2)


if __name__ == "__main__":
    print(cuttingRope(10))