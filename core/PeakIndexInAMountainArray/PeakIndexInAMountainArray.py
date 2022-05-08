from typing import List


def peakIndexInMountainArray(arr: List[int]) -> int:
    left, right = 0, len(arr) - 1
    while left <= right:
        mid = (left + right) // 2
        if arr[mid - 1] < arr[mid] > arr[mid + 1]:
            return mid
        if arr[mid] < arr[mid + 1]:
            left = mid + 1
        else:
            right = mid - 1

    return 0

if __name__ == '__main__':
    print(peakIndexInMountainArray([0,1,0]))


