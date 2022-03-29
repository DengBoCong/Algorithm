def addStrings(num1: str, num2: str) -> str:
    res, remain = "", 0
    left, right = len(num1) - 1, len(num2) - 1
    while left >= 0 and right >= 0:
        temp = int(num1[left]) + int(num2[right]) + remain
        remain = temp // 10
        res = str(temp % 10) + res
        left -= 1
        right -= 1

    point = left if left >= 0 else right
    num = num1 if left >= 0 else num2
    while point >= 0:
        temp = int(num[point]) + remain
        remain = temp // 10
        res = str(temp % 10) + res
        point -= 1

    if remain != 0:
        res = str(remain) + remain

    return res

