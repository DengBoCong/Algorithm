from typing import List

def search(nums: List[int], target: int) -> bool:
    left, right, length = 0, len(nums) - 1, len(nums)
    while left <= right:
        mid = (left + right) // 2
        if nums[mid] == target:
            return True
        if nums[mid] == nums[left] and nums[mid] == nums[right]:
            left += 1
            right -= 1
        elif nums[mid] >= nums[left]:
            if nums[left] <= target < nums[mid]:
                right = mid - 1
            else:
                left = mid + 1
        else:
            if nums[mid] < target <= nums[right]:
                left = mid + 1
            else:
                right = mid - 1
    return False

if __name__ == '__main__':
    # print(search(nums = [2,5,6,0,0,1,2], target = 0))
    # print(search(nums = [2,5,6,0,0,1,2], target = 3))
    print(search(nums=[1,0,1,1,1], target=0))


