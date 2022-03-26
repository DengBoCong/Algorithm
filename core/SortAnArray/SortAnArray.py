import random
from typing import List


def sortArray(nums: List[int]) -> List[int]:
    def quick_sort(left, right):
        l, r = left, right
        mid = random.randint(left, right)
        nums[left], nums[mid] = nums[mid], nums[left]
        mid = nums[left]
        while left < right:
            while left < right and nums[right] >= mid:
                right -= 1
            if left < right:
                nums[left] = nums[right]
                left += 1
            while left < right and nums[left] <= mid:
                left += 1
            if left < right:
                nums[right] = nums[left]
                right -= 1

        nums[left] = mid
        if l < left - 1:
            quick_sort(l, left - 1)
        if left + 1 < r:
            quick_sort(left + 1, r)

    quick_sort(0, len(nums) - 1)
    return nums


def max_heapify(point, heap, heap_len):
    while point * 2 + 1 < heap_len:
        l, r = point * 2 + 1, point * 2 + 2
        if r >= heap_len or heap[l] > heap[r]:
            max_node = l
        else:
            max_node = r

        if heap[point] < heap[max_node]:
            heap[point], heap[max_node] = heap[max_node], heap[point]
        point = max_node


def heap_sort(nums):
    length = len(nums)
    for i in range(length - 1, -1, -1):
        max_heapify(i, nums, length)
    for i in range(length - 1, -1, -1):
        nums[0], nums[i] = nums[i], nums[0]
        max_heapify(0, nums, i)


def merge_sort(left, right, nums):
    if left > right:
        return []
    if left == right:
        return [nums[left]]

    mid = (left + right) // 2
    left_nums = merge_sort(left, mid, nums)
    right_nums = merge_sort(mid + 1, right, nums)

    l, r = 0, 0
    res = []
    while l < len(left_nums) and r < len(right_nums):
        res.append(min(left_nums[l], right_nums[r]))
        if left_nums[l] <= right_nums[r]:
            l += 1
        else:
            r += 1

    point = r if l == len(left_nums) else l
    point_num = right_nums if l == len(left_nums) else left_nums
    while point < len(point_num):
        res.append(point_num[point])
        point += 1

    return res


if __name__ == '__main__':
    print(sortArray([5, 2, 3, 1]))
    nums = [-4, 0, 7, 4, 9, -5, -1, 0, -7, -1]
    # heap_sort(nums)
    print(merge_sort(0, len(nums) - 1, nums))
