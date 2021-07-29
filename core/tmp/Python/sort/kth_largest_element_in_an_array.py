from typing import List


def quick_find(nums: List[int], left: int, right: int, k: int):
    l = left
    r = right
    mid = nums[left]
    while l < r:
        while l < r and nums[r] >= mid:
            r -= 1
        if l < r:
            nums[l] = nums[r]
            l += 1
        while l < r and nums[l] <= mid:
            l += 1
        if l < r:
            nums[r] = nums[l]
            r -= 1
    nums[l] = mid
    if l + 1 == k:
        return mid
    elif l + 1 > k:
        return quick_find(nums, left, l - 1, k)
    else:
        return quick_find(nums, l + 1, right, k)


def findKthLargestQuick(nums: List[int], k: int) -> int:
    return quick_find(nums, 0, len(nums) - 1, len(nums) - k + 1)


def swap(nums: List[int], index1: int, index2: int):
    temp = nums[index1]
    nums[index1] = nums[index2]
    nums[index2] = temp


def heapify(nums: List[int], i: int, length: int):
    left = 2 * i + 1
    right = 2 * i + 2
    largest = i
    if left < length and nums[largest] < nums[left]:
        largest = left
    if right < length and nums[largest] < nums[right]:
        largest = right

    if i != largest:
        swap(nums, largest, i)
        heapify(nums, largest, length)


def findKthLargestHeap(nums: List[int], k: int) -> int:
    length = len(nums)
    for i in range(length // 2, 0, -1):
        heapify(nums, i - 1, length)

    for i in range(k - 1):
        swap(nums, 0, length - 1 - i)
        heapify(nums, 0, length - 1 - i)

    return nums[0]


if __name__ == "__main__":

    print(findKthLargestHeap(nums=[2,1], k=2))
