from typing import List

def maxSubArray(nums: List[int]) -> int:
    n = len(nums)
    result = nums[0]
    for i in range(1, n):
        if nums[i] < nums[i] + nums[i - 1]:
            nums[i] = nums[i] + nums[i - 1]
        result = max(result, nums[i])

    return result

if __name__ == "__main__":
    print(maxSubArray([-1000]))    
