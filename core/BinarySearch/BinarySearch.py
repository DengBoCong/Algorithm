from typing import List

def search(nums: List[int], target: int) -> int:
    def binary_search(left, right):
        if left > right:
            return -1

        mid = (left + right) // 2
        if nums[mid] == target:
            return mid
        left_num = binary_search(left, mid - 1)
        right_num = binary_search(mid + 1, right)
        if left_num != -1:
            return left_num
        elif right_num != -1:
            return right_num

        return -1

    return binary_search(0, len(nums) - 1)


