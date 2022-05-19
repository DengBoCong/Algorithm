from typing import List
import random


def minMoves2(nums: List[int]) -> int:
    def quick_select(left, right, target):
        l, r = left, right
        index = random.randint(left, right)
        index_num = nums[index]
        nums[r], nums[index] = nums[index], nums[r]
        index = l
        for i in range(l, r):
            if nums[i] <= index_num:
                nums[index], nums[i] = nums[i], nums[index]
                index += 1
        nums[index], nums[r] = nums[r], nums[index]
        if index == target:
            return nums[index]
        elif index > target:
            return quick_select(left, index - 1, target)
        else:
            return quick_select(index + 1, right, target)

    mid_num = quick_select(0, len(nums) - 1, len(nums) // 2)
    return sum([abs(mid_num - num) for num in nums])



if __name__ == '__main__':
    print(minMoves2([1,10,2,9]))



