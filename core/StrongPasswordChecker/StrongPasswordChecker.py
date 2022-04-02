def strongPasswordChecker(self, password: str) -> int:
    n = len(password)
    has_lower = has_upper = has_digit = False
    for ch in password:
        if ch.islower():
            has_lower = True
        elif ch.isupper():
            has_upper = True
        elif ch.isdigit():
            has_digit = True

    categories = has_lower + has_upper + has_digit

    if n < 6:
        return max(6 - n, 3 - categories)
    elif n <= 20:
        replace = cnt = 0
        cur = "#"

        for ch in password:
            if ch == cur:
                cnt += 1
            else:
                replace += cnt // 3
                cnt = 1
                cur = ch

        replace += cnt // 3
        return max(replace, 3 - categories)
    else:
        # 替换次数和删除次数
        replace, remove = 0, n - 20
        # k mod 3 = 1 的组数，即删除 2 个字符可以减少 1 次替换操作
        rm2 = cnt = 0
        cur = "#"

        for ch in password:
            if ch == cur:
                cnt += 1
            else:
                if remove > 0 and cnt >= 3:
                    if cnt % 3 == 0:
                        # 如果是 k % 3 = 0 的组，那么优先删除 1 个字符，减少 1 次替换操作
                        remove -= 1
                        replace -= 1
                    elif cnt % 3 == 1:
                        # 如果是 k % 3 = 1 的组，那么存下来备用
                        rm2 += 1
                    # k % 3 = 2 的组无需显式考虑
                replace += cnt // 3
                cnt = 1
                cur = ch

        if remove > 0 and cnt >= 3:
            if cnt % 3 == 0:
                remove -= 1
                replace -= 1
            elif cnt % 3 == 1:
                rm2 += 1

        replace += cnt // 3

        # 使用 k % 3 = 1 的组的数量，由剩余的替换次数、组数和剩余的删除次数共同决定
        use2 = min(replace, rm2, remove // 2)
        replace -= use2
        remove -= use2 * 2
        # 由于每有一次替换次数就一定有 3 个连续相同的字符（k / 3 决定），因此这里可以直接计算出使用 k % 3 = 2 的组的数量
        use3 = min(replace, remove // 3)
        replace -= use3
        remove -= use3 * 3
        return (n - 20) + max(replace, 3 - categories)


if __name__ == '__main__':
    print(strongPasswordChecker("1337C0d3"))



