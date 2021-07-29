from typing import *

def isStraight(nums: List[int]) -> bool:
    nums.sort()
    wang = 0
    for i in range(len(nums) - 1):
        if nums[i] == 0:
            wang += 1
        elif nums[i + 1] - 1 - nums[i] < 0:
            return False
        elif nums[i] != nums[i + 1] - 1:
            wang -= nums[i + 1] - 1 - nums[i]
    
    return True if wang >= 0 else False

if __name__ == "__main__":
    print(isStraight([0,12,11,11,0]))