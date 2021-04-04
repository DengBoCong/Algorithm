from typing import *

def reversePairs(nums: List[int]) -> int:
    temp = [0] * len(nums)
    def merge_sort(left, right):
        if left >= right:
            return 0
        mid = (left + right) // 2
        res = merge_sort(left, mid) + merge_sort(mid + 1, right)
        i, j = left, mid + 1
        temp[left:right+1] = nums[left:right+1]
        for k in range(left, right + 1):
            if i == mid + 1:
                nums[k] = temp[j]
                j += 1
            elif j == right + 1 or temp[i] <= temp[j]:
                nums[k] = temp[i]
                i += 1
            else:
                nums[k] = temp[j]
                j += 1
                res += mid - i + 1
        
        return res
    return merge_sort(0, len(nums) - 1)
    
    
            

