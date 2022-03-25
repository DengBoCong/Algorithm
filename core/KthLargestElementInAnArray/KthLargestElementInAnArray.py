from typing import List


def findKthLargest(nums: List[int], k: int) -> int:
    def quick_sort(left, right):
        point = nums[left]
        l, r = left, right
        while left < right:
            while left < right and nums[right] <= point:
                right -= 1
            if left < right:
                nums[left] = nums[right]
                left += 1
            while left < right and nums[left] >= point:
                left += 1
            if left < right:
                nums[right] = nums[left]
                right -= 1

        nums[left] = point
        if left + 1 == k:
            return point
        elif left + 1 > k:
            return quick_sort(l, right - 1)
        else:
            return quick_sort(left + 1, r)

    return quick_sort(0, len(nums) - 1)


if __name__ == '__main__':
    print(findKthLargest([3,2,3,1,2,4,5,5,6], 4))
