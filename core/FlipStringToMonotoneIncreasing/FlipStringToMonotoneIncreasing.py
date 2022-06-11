def minFlipsMonoIncr(s: str) -> int:
    dp0 = dp1 = 0
    for ch in s:
        dp0_new, dp1_new = dp0, min(dp0, dp1)
        if ch == "1":
            dp0_new += 1
        else:
            dp1_new += 1
        dp0, dp1 = dp0_new, dp1_new

    return min(dp0, dp1)


if __name__ == '__main__':
    print(minFlipsMonoIncr("10011111110010111011"))




