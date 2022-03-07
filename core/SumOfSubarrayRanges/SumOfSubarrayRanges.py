from typing import List

def subArrayRanges(nums: List[int]) -> int:
    min_left, max_left, min_right, max_right = [], [], [], []
    stack1, stack2 = [], []
    for i in range(len(nums)):
        while stack1 and nums[stack1[-1]] >= nums[i]:
            stack1.pop()

        min_left.append(stack1[-1] if stack1 else -1)
        stack1.append(i)

        while stack2 and nums[stack2[-1]] <= nums[i]:
            stack2.pop()

        max_left.append(stack2[-1] if stack2 else -1)
        stack2.append(i)

    stack1, stack2 = [], []
    for i in range(len(nums) - 1, -1, -1):
        while stack1 and nums[stack1[-1]] > nums[i]:
            stack1.pop()

        min_right.insert(0, stack1[-1] if stack1 else len(nums))
        stack1.append(i)

        while stack2 and nums[stack2[-1]] < nums[i]:
            stack2.pop()

        max_right.insert(0, stack2[-1] if stack2 else len(nums))
        stack2.append(i)

    min_sum = sum([(right - index) * (index - left) * nums[index] for index, (left, right) in enumerate(zip(min_left, min_right))])
    max_sum = sum([(right - index) * (index - left) * nums[index] for index, (left, right) in enumerate(zip(max_left, max_right))])

    return max_sum - min_sum

if __name__ == '__main__':
    print(subArrayRanges([1,3,3]))
