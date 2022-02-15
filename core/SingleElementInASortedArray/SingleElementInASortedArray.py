from typing import List


def singleNonDuplicate(nums: List[int]) -> int:
    if len(nums) == 1:
        return nums[0]
    left, right = 0, len(nums) - 1
    while left < right:
        print(left, right)
        mid = (right - left) // 2 + left
        if nums[mid] != nums[mid - 1] and nums[mid] != nums[mid + 1]:
            return nums[mid]
        elif mid % 2 == 0:
            if nums[mid] == nums[mid - 1]:
                right = mid
            else:
                left = mid
        else:
            if nums[mid] == nums[mid - 1]:
                left = mid + 1
            else:
                right = mid - 1

    return nums[left]


def singleNonDuplicate1(nums: List[int]) -> int:
    num = nums[0]
    for i in range(1, len(nums)):
        num = num ^ nums[i]

    return num


if __name__ == "__main__":
    print(singleNonDuplicate1([1, 1, 2]))
