def isHappy(n: int) -> bool:
    remain = {n}
    while n != 1:
        temp = 0
        while n != 0:
            temp += pow((n % 10), 2)
            n = n // 10
        n = temp
        if n in remain:
            return False
        remain.add(n)

    return True


if __name__ == '__main__':
    print(isHappy(2))
