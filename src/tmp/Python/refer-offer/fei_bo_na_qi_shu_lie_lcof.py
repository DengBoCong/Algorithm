def fib(n: int) -> int:
    if n == 0:
        return 0
    if n == 1:
        return 1
    
    f1, f2 = 0, 1
    for i in range(n - 1):
        temp = (f1 + f2) % 1000000007
        f1, f2 = f2, temp
    
    return f2
    
if __name__ == "__main__":
    print(fib(5))