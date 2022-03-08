def addDigits(num: int) -> int:
    while num >= 10:
        temp = 0
        while num != 0:
            temp += num % 10
            num = num // 10

        num = temp

    return num

if __name__ == '__main__':
    print(addDigits(10))
