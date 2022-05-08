from typing import List


def findDuplicates(nums: List[int]) -> List[int]:
    point, length, res = 0, len(nums), []
    while point < length:
        while nums[point] != -1 and nums[point] != 0 and nums[nums[point] - 1] != 0:
            cur = nums[point]
            nums[point] = nums[cur - 1]
            nums[cur - 1] = 0

        if nums[point] != -1 and nums[point] != 0 and nums[nums[point] - 1] == 0:
            res.append(nums[point])
            nums[point] = -1

        point += 1

    return res


if __name__ == '__main__':
    print(findDuplicates([4, 3, 2, 7, 8, 2, 3, 1]))
