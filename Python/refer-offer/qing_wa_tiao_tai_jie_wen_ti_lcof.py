def numWays(n: int) -> int:
    if n == 0 or n == 1:
        return 1
    if n == 2:
        return 2
    f1, f2 = 1, 2
    for i in range(n - 2):
        temp = (f1 + f2) % 1000000007
        f1 = f2
        f2 = temp
    
    return f2

if __name__ == "__main__":
    print(numWays(2))