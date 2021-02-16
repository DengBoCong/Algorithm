from typing import List


def getMaxSubsequence(nums: List[int], k: int) -> int:
    stack = [0] * k
    top = -1
    remain = len(nums) - k

    for i, num in enumerate(nums):
        while top >= 0 and stack[top] < num and remain > 0:
            top -= 1
            remain -= 1
        if top < k - 1:
            top += 1
            stack[top] = num
        else:
            remain -= 1

    return stack


def compare(subsequence1: List[int], index1: int, subsequence2: List[int], index2: int) -> int:
    x, y = len(subsequence1), len(subsequence2)
    while index1 < x and index2 < y:
        difference = subsequence1[index1] - subsequence2[index2]
        if difference != 0:
            return difference
        index1 += 1
        index2 += 1

    return (x - index1) - (y - index2)


def merge(subsequence1: List[int], subsequence2: List[int]) -> List[int]:
    x, y = len(subsequence1), len(subsequence2)
    if x == 0:
        return subsequence2
    if y == 0:
        return subsequence1

    merge_length = x + y
    merged = list()
    index1 = index2 = 0

    for _ in range(merge_length):
        if compare(subsequence1, index1, subsequence2, index2) > 0:
            merged.append(subsequence1[index1])
            index1 += 1
        else:
            merged.append(subsequence2[index2])
            index2 += 1
    return merged


def maxNumber(nums1: List[int], nums2: List[int], k: int) -> List[int]:
    m, n = len(nums1), len(nums2)
    maxSubsequence = [0] * k
    start, end = max(0, k - n), min(k, m)
    for i in range(start, end + 1):
        subsequence1 = getMaxSubsequence(nums1, i)
        subsequence2 = getMaxSubsequence(nums2, k - i)
        curMaxSubsequence = merge(subsequence1, subsequence2)
        if compare(curMaxSubsequence, 0, maxSubsequence, 0) > 0:
            maxSubsequence = curMaxSubsequence
    
    return maxSubsequence
