from typing import *

def find132pattern(nums: List[int]) -> bool:
    min_nums, stack, length = list(), list(), len(nums)
    min_nums.append(nums[0])
    for i in range(1, length):
        min_nums.append(min(nums[i], min_nums[i - 1]))
    
    for i in range(length - 1, -1, -1):
        if nums[i] > min_nums[i]:
            while stack and stack[-1] <= min_nums[i]:
                stack.pop()
            if stack and stack[-1] < nums[i]:
                return True
            stack.append(nums[i])
    
    return False

if __name__ == "__main__":
    print(find132pattern([-1, 3, 2, 0]))