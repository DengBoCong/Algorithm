from typing import *

def merge(nums1: List[int], m: int, nums2: List[int], n: int) -> None:
    point = m + n - 1
    while m > 0 and n > 0:
        if nums1[m - 1] <= nums2[n - 1]:
            nums1[point] = nums2[n - 1]
            n -= 1
        else:
            nums1[point] = nums1[m - 1]
            m -= 1
        point -= 1
