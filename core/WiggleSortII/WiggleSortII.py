import math
from typing import List


def wiggleSort(nums: List[int]) -> None:
    n = len(nums)
    arr = sorted(nums)
    x = (n + 1) // 2
    j, k = x - 1, n - 1
    for i in range(0, n, 2):
        nums[i] = arr[j]
        if i + 1 < n:
            nums[i + 1] = arr[k]
        j -= 1
        k -= 1


if __name__ == '__main__':
    print(wiggleSort([1,3,2,2,3,1]))




