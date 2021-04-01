def clumsy(N: int) -> int:
    num = list()
    num.append(N)
    flag = 0
    for i in range(N - 1, 0, -1):
        if flag == 0:
            num.append(i * num.pop())
        elif flag == 1:
            num.append(int(num.pop() / i))
        elif flag == 2:
            num.append(i)
        elif flag == 3:
            num.append(-i)
        flag = (flag + 1) % 4

    total = 0
    print(num)
    while num:
        total += num.pop()
    return total

if __name__ == "__main__":
    print(clumsy(10))
