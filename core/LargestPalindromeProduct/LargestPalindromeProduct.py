def largestPalindrome(n: int) -> int:
    if n == 1:
        return 9
    max_num = 10 ** n - 1
    for left in range(max_num, max_num // 10, -1):
        p, x = left, left
        while x:
            p = p * 10 + x % 10
            x //= 10
        x = max_num
        while x * x >= p:
            if p % x == 0:
                return p % 1377
            x -= 1

    return -1


if __name__ == '__main__':
    print(largestPalindrome(2))
