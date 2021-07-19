from typing import List

def maxSatisfied(customers: List[int], grumpy: List[int], X: int) -> int:
    length = len(grumpy)
    left, right, imax, remain, total = 0, 0, 0, 0, 0
    while right < X:
        if grumpy[right] == 0:
            total += customers[right]
        else:
            remain += customers[right]
        right += 1

    imax = max(remain, imax)
    while right < length:
        if grumpy[right] == 0:
            total += customers[right]
        else:
            remain += customers[right]
        if grumpy[left] == 1:
            remain -= customers[left]
        imax = max(imax, remain)
        left += 1
        right += 1

    
    return total + imax

if __name__ == "__main__":
    print(maxSatisfied(customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3))