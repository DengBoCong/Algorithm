def countDigitOne(n: int) -> int:
    k, low, res = 1, 0, 0
    while n != 0:
        high = n // 10
        cur = n % 10
        if cur == 0: res += high * k
        elif cur == 1: res += high * k + low + 1
        else: res += (high + 1) * k
        low += cur * k
        k = k * 10
        n = n // 10
    
    return res

if __name__ == "__main__":
    print(countDigitOne(100))