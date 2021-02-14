from typing import List

def firstMissingPositive(nums: List[int]) -> int:
    n = len(nums)
    for i in range(n):
        if nums[i] <= 0:
            nums[i] = n + 1
    
    for i in range(n):
        if abs(nums[i]) < n + 1:
            nums[abs(nums[i]) - 1] = -abs(nums[abs(nums[i]) - 1])

    for i in range(n):
        if nums[i] > 0:
            return i + 1
    
    return n + 1

if __name__ == "__main__":
    print(firstMissingPositive([1,1]))