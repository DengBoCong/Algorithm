import sys


def maximumProduct_sort(nums: list) -> int:
    nums = sorted(nums)
    n = len(nums)
    return max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1])


def maximumProduct(nums: list) -> int:
    min1, min2 = 1001, 1001
    max1, max2, max3 = -1001, -1001, -1001

    for num in nums:
        if num < min1:
            min2 = min1
            min1 = num
        elif num < min2:
            min2 = num

        if num > max1:
            max3 = max2
            max2 = max1
            max1 = num
        elif num > max2:
            max3 = max2
            max2 = num
        elif num > max3:
            max3 = num

    return max(min1 * min2 * max1, max1 * max2 * max3)


if __name__ == "__main__":
    print(maximumProduct([-100, -2, -3, 1]))
