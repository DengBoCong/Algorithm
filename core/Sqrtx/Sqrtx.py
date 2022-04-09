def mySqrt(x: int) -> int:
    if (x // 2) ** 2 < x:
        return x // 2 if x != 1 else 1

    left, right = 0, x // 2
    while left ** 2 <= x <= right ** 2:
        mid = (left + right) // 2
        if mid ** 2 == x:
            return mid

        if mid ** 2 > x:
            right = mid - 1
        else:
            left = mid + 1

    if left ** 2 > x:
        return left - 1 if left ** 2 > x else left
    if right ** 2 < x:
        return right if right ** 2 < x else right - 1

if __name__ == '__main__':
    print(mySqrt(8192))


