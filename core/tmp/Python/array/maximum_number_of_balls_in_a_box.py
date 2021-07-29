def sum_num(num: int) -> int:
    result = 0
    while num > 0:
        result += num % 10
        num //= 10
    
    return result

def countBalls(lowLimit: int, highLimit: int) -> int:
    result = 0
    remain = {}
    for i in range(lowLimit, highLimit + 1):
        num = sum_num(i)
        remain[num] = remain[num] + 1 if num in remain else 1
        result = max(result, remain[num])
        
    return result

if __name__ == "__main__":
    print(countBalls(lowLimit = 19, highLimit = 28))