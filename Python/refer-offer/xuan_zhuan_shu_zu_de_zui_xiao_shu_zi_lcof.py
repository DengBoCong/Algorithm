from typing import *

def minArray(numbers: List[int]) -> int:
    low, high = 0, len(numbers) - 1
    while low < high:
        mid = (low + high) // 2
        if numbers[mid] < numbers[high]:
            high = mid
        elif numbers[mid] > numbers[high]:
            low = mid + 1
        elif numbers[mid] == numbers[high]:
            high -= 1
    
    return numbers[low]


if __name__ == "__main__":
    print(minArray([2,2,2,0,1]))