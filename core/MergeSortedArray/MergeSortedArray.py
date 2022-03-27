from typing import List

def merge(nums1: List[int], m: int, nums2: List[int], n: int) -> None:
    point = m + n - 1
    while m > 0 and n > 0:
        if nums1[m - 1] >= nums2[n - 1]:
            value = nums1[m - 1]
            m -= 1
        else:
            value = nums2[n - 1]
            n -= 1
        nums1[point] = value
        point -= 1

    if m == 0:
        cur = n
        remain = nums2
    else:
        cur = m
        remain = nums1
    while cur > 0:
        nums1[point] = remain[cur - 1]
        cur -= 1
        point -= 1



