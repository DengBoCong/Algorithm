def convertToBase7(num: int) -> str:
    if num == 0:
        return "0"

    res = ""
    temp = abs(num)
    while temp != 0:
        res = str(temp % 7) + res

        temp = temp // 7

    return res if num >= 0 else f"-{res}"


if __name__ == '__main__':
    print(convertToBase7(0))
