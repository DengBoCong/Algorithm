def hammingWeight(n: int) -> int:
    result = 0
    while n != 0:
        result += 1
        n = n & (n - 1)
    
    return result