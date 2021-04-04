def nthUglyNumber(n: int) -> int:
    dp = [1]
    point1, point2, point3 = 0, 0, 0
    for i in range(1, n):
        num1 = dp[point1] * 2
        num2 = dp[point2] * 3
        num3 = dp[point3] * 5
        if num1 <= num2 and num1 <= num3: point1 += 1
        if num2 <= num1 and num2 <= num3: point2 += 1
        if num3 <= num2 and num3 <= num1: point3 += 1
        dp.append(min(num1, num2, num3))
    
    return dp[-1]

if __name__ == "__main__":
    print(nthUglyNumber(10))