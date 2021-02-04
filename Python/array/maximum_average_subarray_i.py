from typing import List

def findMaxAverage(nums: List[int], k: int) -> float:
    result = sum(nums[:k])
    remain = sum(nums[:k])
    for i in range(k, len(nums)):
        remain = remain + nums[i] - nums[i - k]
        result = max(result, remain)
    
    return result / k

if __name__ == "__main__":
    print(findMaxAverage(nums=[0,4,0,3,2], k = 1))
