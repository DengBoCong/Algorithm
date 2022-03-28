def hasAlternatingBits(n: int) -> bool:
    flag = -1
    while n != 0:
        if flag != -1 and flag == n % 2:
            return False
        flag = n % 2
        n >>= 1

    return True



