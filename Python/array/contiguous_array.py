from typing import List

def findMaxLength(nums: List[int]) -> int:
    sum_0, sum_1, result, remain = 0, 0, 0, {}
    for i in range(len(nums)):
        if nums[i] == 0:
            sum_0 += 1
        else:
            sum_1 += 1
        
        num = sum_0 - sum_1
        if num == 0:
            result = max(result, i + 1)
        elif remain.get(num, 50000) != 50000:
            result = max(result, i - remain[num])
        else:
            remain[num] = i
    
    return result

if __name__ == "__main__":
    print(findMaxLength([0,1]))

