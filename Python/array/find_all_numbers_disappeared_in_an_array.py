from typing import List


def findDisappearedNumbers(nums: List[int]) -> List[int]:
    n = len(nums)
    for num in nums:
        num = num % n
        nums[num - 1] += n

    result = []
    for i in range(n):
        if nums[i] <= n:
            result.append(i + 1)

    return result


if __name__ == "__main__":
    print(findDisappearedNumbers([4, 3, 2, 7, 8, 2, 3, 1]))
