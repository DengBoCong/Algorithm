from typing import List


def removeElement(nums: List[int], val: int) -> int:
    point, cur, length = 0, 0, len(nums)
    while cur < length:
        if nums[cur] != val:
            nums[cur], nums[point] = nums[point], nums[cur]
            point += 1
        cur += 1
    return point




