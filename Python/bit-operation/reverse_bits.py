def reverseBits(n: int) -> int:
    res = 0
    for i in range(32):
        if n == 0: break
        res |= (n & 1) << (31 - i)
        n = n >> 1
    
    return res


if __name__ == "__main__":
    print(reverseBits(-3))