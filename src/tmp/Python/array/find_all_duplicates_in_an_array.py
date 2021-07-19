from typing import List

def findDuplicates(nums: List[int]) -> List[int]:
    n = len(nums)
    result = []
    for num in nums:
        num = (num - 1) % n
        if nums[num] > n:
            result.append(num + 1)
        nums[num] += n
    
    return result

if __name__ == "__main__":
    print(findDuplicates([2,2]))