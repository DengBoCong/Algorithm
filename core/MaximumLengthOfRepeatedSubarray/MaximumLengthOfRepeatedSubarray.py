from typing import List


def findLength(nums1: List[int], nums2: List[int]) -> int:
    rows, cols = len(nums1) + 1, len(nums2) + 1
    dp, res = [0] * cols, 0
    for row in range(1, rows):
        remain = 0
        for col in range(1, cols):
            temp = dp[col]
            if nums1[row - 1] == nums2[col - 1]:
                dp[col] = remain + 1
            else:
                dp[col] = 0
            remain = temp
            res = max(res, dp[col])

    return res


if __name__ == '__main__':
    print(findLength([1, 0, 0, 0, 1], [1, 0, 0, 1, 1]))
