from typing import List

def threeSum(nums: List[int]) -> List[List[int]]:
    nums.sort()
    length = len(nums)
    res = []
    for i in range(length - 2):
        if i != 0 and nums[i] == nums[i - 1]:
            continue
        target = -nums[i]
        third = length - 1
        for j in range(i + 1, length - 1):
            if j != i + 1 and nums[j] == nums[j - 1]:
                continue
            while j < third and nums[j] + nums[third] > target:
                third -= 1
            if j == third:
                break
            elif nums[j] + nums[third] == target:
                res.append([nums[i], nums[j], nums[third]])

    return res


if __name__ == '__main__':
    print(threeSum([-1,0,1,2,-1,-4]))
